package farmappceuticos.farmappcia.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import farmappceuticos.farmappcia.model.Event;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.model.UserMedicine;
import farmappceuticos.farmappcia.services.EventService;
import farmappceuticos.farmappcia.services.UserMedicineService;
import farmappceuticos.farmappcia.services.UserService1;
import farmappceuticos.farmappcia.util.Date;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller
public class CalendarController {

    @Autowired
    private EventService eventService;

    @Autowired
    UserMedicineService userMedicineService;

    @Autowired
            private UserService1 userService;
    HashMap<String, ArrayList<Date>> calendar = new HashMap<>();

    HashMap<String, Date[][]> dateValues = new HashMap<>();
    List<Event> eventListPantalla = new ArrayList<>();
    List<Event> eventListDB = new ArrayList<>();

    //Medicamentos
    List<UserMedicine> userMedicineListPantalla = new ArrayList<>();
    List<UserMedicine> userMedicineListDB = new ArrayList<>();



    @GetMapping("/usuario/calendario")
    public ModelAndView doGetMes(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User user = userService.findByName(userName);
        model.addAttribute("user",user);
        int intmonth = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear();
        return doPostMes(String.valueOf(intmonth),String.valueOf(year),model);
    }

    @PostMapping("/usuario/calendario")
    public ModelAndView doPostMes(@RequestParam String month ,@RequestParam String year,Model model) {
        ModelAndView mv = null;
        calendar.clear();
        dateValues.clear();
        eventListDB.clear();
        eventListPantalla.clear();
        userMedicineListDB.clear();
        userMedicineListPantalla.clear();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User user = userService.findByName(userName);
        model.addAttribute("user",user);


        int yr = Integer.parseInt(year);
        int mo = Integer.parseInt(month);

        //Construimos el calendario
        buildCalendar(mo,yr); // Calendar hash map is built.
        //Generamos un
        String strdaymin =  	year + "-" +
                String.format("%02d" , mo) + "-01 00:00:00";
        String strdaymax =  	year + "-" +
                String.format("%02d" , mo+1) + "-01 00:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTimemin = LocalDateTime.parse(strdaymin, formatter);
        LocalDateTime dateTimemax = LocalDateTime.parse(strdaymax, formatter);
        //Buscamos en la lista
        eventListDB = eventService.getRepo().findEventByFechahoraBetween(dateTimemin,dateTimemax );
        userMedicineListDB=userMedicineService.getRepo().findUserMedicineByFechainicioBetween(dateTimemin,dateTimemax);
        //Volcamos datos al "dto"
        // https://www.redcort.com/us-federal-bank-holidays/
        //setAllHolidays(yr); // isHoliday field of date set to true if its a holiday
        formatDatesEvent(Date.MONTH[mo]);
        formatDatesUserMedicine(Date.MONTH[mo]);
        mv = new ModelAndView("calendario/calendarunmes");

        mv.addAllObjects(dateValues);
        mv.addObject("events", eventListPantalla);
        mv.addObject("userMedicines", userMedicineListPantalla);
        mv.addObject("year", year);
        mv.addObject("month", mo);
        return mv;
    }








    private void formatDatesEvent(String monthin) {

        System.out.println("formatDates Mes selecionado:" + monthin );

        ArrayList<Date> month = calendar.get(monthin);
        dateValues.put(monthin, dateFormatterEvent(month));
    }

    private void formatDatesUserMedicine(String monthin) {

        System.out.println("formatDates Mes selecionado:" + monthin );

        ArrayList<Date> month = calendar.get(monthin);
        dateValues.put(monthin, dateFormatterUserMedicine(month));
    }


    private Date[][] dateFormatterEvent(ArrayList<Date> month) {
        int dayPointer = 0;
        Date[][] days = new Date[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (dayPointer < month.size()) {
                    if (month.get(dayPointer).getDow() == j) {
                        System.out.println("dateFormatterEvent dia mes:" + month.get(dayPointer) );
                        days[i][j] = month.get(dayPointer);
                        //Comnponemos los eventos para la pantalla
                        for (Event event : eventListDB){
                            if (event.getDiames().equals( month.get(dayPointer).getDay())){
                                eventListPantalla.add(event);
                            }
                        }
                        dayPointer++;
                        continue;
                    }
                }
                Date nullDate = null;
                days[i][j] = nullDate;
            }
        }
        return days;
    }

    private Date[][] dateFormatterUserMedicine(ArrayList<Date> month) {
        int dayPointer = 0;

        List<UserMedicine> userMedicineList=new ArrayList<>();

        for (UserMedicine userMedicine : userMedicineListDB) {

            int v=0;
            while (userMedicine.getMomentos().size() > v) {
                UserMedicine userMedicine1=new UserMedicine();
                clonar(userMedicine1,userMedicine);
                userMedicine1.setFechainicio(userMedicine.getMomentos().get(v));
                userMedicine1.setDiames(userMedicine1.getFechainicio().getDayOfMonth());
                userMedicine1.setHora(userMedicine1.getFechainicio().getHour() + ":" + userMedicine1.getFechainicio().getMinute());

                userMedicineList.add(userMedicine1);
                v++;

            }
        }


        Date[][] days = new Date[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (dayPointer < month.size()) {
                    if (month.get(dayPointer).getDow() == j) {
                        System.out.println("dateFormatterUserMedicine dia mes:" + month.get(dayPointer) );
                        days[i][j] = month.get(dayPointer);
                        //Comnponemos los userMedicine para la pantalla

                        for (UserMedicine userMedicine1 : userMedicineList){

                            if (userMedicine1.getDiames().equals( month.get(dayPointer).getDay())){
                                userMedicineListPantalla.add(userMedicine1);
                            }
                        }
                        dayPointer++;
                        continue;
                    }
                }
                Date nullDate = null;
                days[i][j] = nullDate;
            }
        }
        return days;
    }

    public void clonar(UserMedicine clon,UserMedicine padre){
        clon.setNotificar(padre.getNotificar());
        clon.setActive(padre.getActive());
        clon.setCadahoras(padre.getCadahoras());
        clon.setUserToMedicine(padre.getUserToMedicine());
        clon.setNotificarTutor(padre.getNotificarTutor());
        clon.setFechafinal(padre.getFechafinal());
        clon.setMedicineToMedicine(padre.getMedicineToMedicine());
    }



    private void buildCalendar(int month ,int year) {
        //Obtener el dia de la semana del primes dia de cada nes del año
        System.out.println(
                "Entrada a buildCalendar:  mes:" + month + ", año:" + year
        );
        Date jan1st = new Date(1, 1, year);
        jan1st.setDow(Date.calculateDowForJan1st(year));

        Date feb1st = new Date(2, 1, year, jan1st, 31);
        int febDays = Date.isLeapYear(year) ? 29 : 28; // deal with leap day
        Date mar1st = new Date(3, 1, year, feb1st, febDays);
        Date apr1st = new Date(4, 1, year, mar1st, 31);
        Date may1st = new Date(5, 1, year, apr1st, 30);
        Date jun1st = new Date(6, 1, year, may1st, 31);
        Date jul1st = new Date(7, 1, year, jun1st, 30);
        Date aug1st = new Date(8, 1, year, jul1st, 31);
        Date sep1st = new Date(9, 1, year, aug1st, 31);
        Date oct1st = new Date(10, 1, year, sep1st, 30);
        Date nov1st = new Date(11, 1, year, oct1st, 31);
        Date dec1st = new Date(12, 1, year, nov1st, 30);



        switch(month) {
            case 1:
                // code block
                //construimos los datos del mes
                buildMonth(jan1st, 31, 1);
                break;
            case 2:
                // code block
                buildMonth(feb1st, febDays, 2);
                break;
            case 3:
                // code block
                buildMonth(mar1st, 31, 3);
                break;
            case 4:
                // code block
                buildMonth(apr1st, 30, 4);
                break;
            case 5:
                // code block
                buildMonth(may1st, 31, 5);
                break;
            case 6:
                // code block
                buildMonth(jun1st, 30, 6);
                break;
            case 7:
                // code block
                buildMonth(jul1st, 31, 7);
                break;
            case 8:
                // code block
                buildMonth(aug1st, 31, 8);
                break;
            case 9:
                // code block
                buildMonth(sep1st, 30, 9);
                break;
            case 10:
                // code block
                buildMonth(oct1st, 31, 10);
                break;
            case 11:
                // code block
                buildMonth(nov1st, 30, 11);
                break;
            case 12:
                // code block
                buildMonth(dec1st, 31, 12);
                break;

            default:
                // code block
                buildMonth(jan1st, 31, 1);
        }
    }

    private void buildMonth(Date day1st, int monthDays, int monthNum) {
        ArrayList<Date> month = new ArrayList<>();
        month.add(day1st);

        // i represents day
        for (int i = 2; i <= monthDays; i++) {
            Date date = new Date(monthNum, i, day1st.getYear());
            int dow = (day1st.getDow() + (i - 1)) % 7; // dow = (1st day + elapsed days) % 7
            date.setDow(dow);
            month.add(date);
        }
        calendar.put(Date.MONTH[monthNum], month);
    }

}
