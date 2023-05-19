package farmappceuticos.farmappcia.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import farmappceuticos.farmappcia.model.*;
import farmappceuticos.farmappcia.services.UserService1;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class PDFGeneratorController {

    @Autowired
    UserService1 userService;

    @GetMapping("/usuario/historialmedico/pdf")
    public String generatePDF(HttpServletResponse response) {
        // Aquí deberías obtener el usuario con el ID proporcionado desde tu base de datos o cualquier otra fuente de datos
        User user = getUserAuten();

        try {
            Document document = getPDF(user);

            // Establecer las cabeceras para la descarga del archivo
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=HistorialMedico.pdf");

            // Leer el archivo PDF y escribirlo en la respuesta
            InputStream inputStream = new FileInputStream("HistorialMedico.pdf");
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();

            // Eliminar el archivo PDF temporal después de enviarlo en la respuesta
            File file = new File("HistorialMedico.pdf");
            file.delete();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
            return "Error al generar el PDF: " + e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return "redirect:/usuario/historialmedico";  }



    @GetMapping("/usuario/pdf/")
    public String generateFicha(HttpServletResponse response) {
        // Aquí deberías obtener el usuario con el ID proporcionado desde tu base de datos o cualquier otra fuente de datos
        User user = getUserAuten();

        try {
            Document document = getDataUser(user);

            // Establecer las cabeceras para la descarga del archivo
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Ficha.pdf");

            // Leer el archivo PDF y escribirlo en la respuesta
            InputStream inputStream = new FileInputStream("Ficha.pdf");
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();

            // Eliminar el archivo PDF temporal después de enviarlo en la respuesta
            File file = new File("Ficha.pdf");
            file.delete();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
            return "Error al generar el PDF: " + e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return "redirect:/usuario/";  }

    @GetMapping("/usuario/pdf/{id}")
    public String generateFichaCareGiver(@PathVariable("id") Integer id,HttpServletResponse response) {
        // Aquí deberías obtener el usuario con el ID proporcionado desde tu base de datos o cualquier otra fuente de datos
        User tutor = getUserAuten();
        Optional<User> user=userService.findById(id);
        String tutorEmail=tutor.getEmail();
        if (user.isPresent()) {
            if (user.get().getTutorMail().equals(tutorEmail)){


                try {
            Document document = getDataUser(user.get());

            // Establecer las cabeceras para la descarga del archivo
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=Ficha.pdf");

            // Leer el archivo PDF y escribirlo en la respuesta
            InputStream inputStream = new FileInputStream("Ficha.pdf");
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();

            // Eliminar el archivo PDF temporal después de enviarlo en la respuesta
            File file = new File("Ficha.pdf");
            file.delete();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
            return "Error al generar el PDF: " + e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);

                }

            }}
        return "redirect:/usuario/";  }



    @GetMapping("/usuario/caregiver/pdf/{id}")
    public String generatePDF(@PathVariable("id") Integer id,HttpServletResponse response) {
        // Aquí deberías obtener el usuario con el ID proporcionado desde tu base de datos o cualquier otra fuente de datos
        User tutor = getUserAuten();
        Optional<User> user=userService.findById(id);
        String tutorEmail=tutor.getEmail();
        if (user.isPresent()) {
            if (user.get().getTutorMail().equals(tutorEmail)){

        try {
            Document document = getPDF(user.get());

            // Establecer las cabeceras para la descarga del archivo
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=HistorialMedico.pdf");

            // Leer el archivo PDF y escribirlo en la respuesta
            InputStream inputStream = new FileInputStream("HistorialMedico.pdf");
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();

            // Eliminar el archivo PDF temporal después de enviarlo en la respuesta
            File file = new File("HistorialMedico.pdf");
            file.delete();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
            return "Error al generar el PDF: " + e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

            }} return "redirect:/usuario/caregiver/" + id;
    }



    public Document getPDF(User user) throws FileNotFoundException, DocumentException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream("HistorialMedico.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Chunk chunk = new Chunk("Historial médico de " + user.getName(), font);
        document.add(chunk);

        for (MedicalHistory medicalHistory:user.getMedicalHistories()
             ) {

        Paragraph paragraph=new Paragraph();
        paragraph.add("\nFecha del incidente: " + medicalHistory.getFechaIncidencia());

            paragraph.add("\nParte : " + medicalHistory.getIllnessToMedicalHistory().getNombre());
            paragraph.add("\nSíntomas: " + medicalHistory.getDiagnostico());
            paragraph.add("\n¿Ingreso?: " + medicalHistory.getIngreso());
            paragraph.add("\nHospital : " + medicalHistory.getUbiHospital() + "\n\n");
            document.add(paragraph);
        }
        

        document.close();
        return document;
    }


    private User getUserAuten(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = null;
        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }
        String userName = userDetails.getUsername();
        User user=userService.findByName(userName);
        return user;
    }


    public Document getDataUser(User user) throws FileNotFoundException, DocumentException {

        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, new FileOutputStream("Ficha.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.BLACK);
        Chunk chunk = new Chunk("Ficha médica de " + user.getName(), font);
        document.add(chunk);


        Paragraph data=new Paragraph();
        data.add("\nNombre: " + user.getName());
        data.add("\nEmail: " + user.getEmail());
        data.add("\nFecha de nacimiento: " + user.getBirthDate().getDayOfMonth() + "/" +
                user.getBirthDate().getMonthValue()+"/" + user.getBirthDate().getYear());
        data.add("\nEmail del tutor: " + user.getTutorMail());
       if(user.getUserDataToUser()!=null){

           data.add("\n\nDatos médicos");
           data.add("\nTeléfono: " + user.getUserDataToUser().getTelefono());
           data.add("\nDirección: " + user.getUserDataToUser().getDireccion());
           data.add("\nCiudad: " + user.getUserDataToUser().getCiudad());
           data.add("\nDatos personales");
           data.add("\nAltura: " + user.getUserDataToUser().getAltura());
           data.add("\nPeso: " + user.getUserDataToUser().getPeso());
           data.add("\nGrupo Sanguíneo: " + user.getUserDataToUser().getGrupoSangre());
           data.add("\nAlergias: " + user.getUserDataToUser().getAlergias());

       }
        document.add(data);

        LineSeparator lineSeparator = new LineSeparator();
        lineSeparator.setLineColor(BaseColor.BLACK);
        lineSeparator.setLineWidth(0.5f); // Ajustar el grosor de la línea aquí (en puntos)
        Chunk lineChunk = new Chunk(lineSeparator);
        document.add(lineChunk);
        Chunk chunk2 = new Chunk("\n\nHistorial médico", font);
        document.add(chunk2);
        if(user.getMedicalHistories()!=null || user.getMedicalHistories().size()>0){
            for (MedicalHistory medicalHistory:user.getMedicalHistories()) {

            Paragraph paragraph=new Paragraph();
            paragraph.add("Fecha del incidente: " + medicalHistory.getFechaIncidencia());

            paragraph.add("\nParte : " + medicalHistory.getIllnessToMedicalHistory().getNombre());
            paragraph.add("\nSíntomas: " + medicalHistory.getDiagnostico());
            paragraph.add("\n¿Ingreso?: " + medicalHistory.getIngreso());
            paragraph.add("\nHospital : " + medicalHistory.getUbiHospital() + "\n\n");
            document.add(paragraph);
            }
        }

        document.add(lineChunk);

        Chunk citas = new Chunk("\n\nCitas médicas", font);
        document.add(citas);
        if(user.getAgendaToUser()!=null){
            if (user.getAgendaToUser().getEventsToAgenda()!=null || user.getAgendaToUser().getEventsToAgenda().size()>0){
            for (Event event:user.getAgendaToUser().getEventsToAgenda()) {

                Paragraph paragraph=new Paragraph();
                paragraph.add("Fecha de la cita: " + event.getFechahora().getDayOfMonth()+"/"+event.getFechahora().getMonthValue() + " a las " + event.getHora());
                paragraph.add("\n" + event.getNombre());
                paragraph.add("\nDescripción: " + event.getDescripcion());
                paragraph.add("\nEspecialización: " + event.getEspecializacion());
                paragraph.add("\nUbicación : " + event.getUbicacion() + "\n\n");
                document.add(paragraph);
            }
            }else {
                Paragraph paragraph=new Paragraph();
                paragraph.add("No hay datos sobre las citas médicas de " + user.getName()+"\n\n");
                document.add(paragraph);
            }
        }else {
            Paragraph paragraph=new Paragraph();
            paragraph.add("No hay datos sobre las citas médicas de " + user.getName()+"\n\n");
            document.add(paragraph);}


        document.add(lineChunk);

        Chunk usermed = new Chunk("\n\nPastillero", font);
        document.add(usermed);
            if (user.getUserMedicines()!=null || user.getUserMedicines().size()>0){
                for (UserMedicine userMedicine:user.getUserMedicines()) {

                    Paragraph paragraph=new Paragraph();
                    paragraph.add("Tomas del medicamento: " + userMedicine.getMedicineToMedicine().getName());
                    paragraph.add("\nRazón " + userMedicine.getDescripcion());
                    paragraph.add("\nFecha de inicio de tratamiento" + userMedicine.getFechainicio().getDayOfMonth()+"-"+userMedicine.getFechainicio().getMonthValue()+
                            " a las " + userMedicine.getFechainicio().getHour() + ":" + userMedicine.getFechainicio().getMinute());
                    paragraph.add("\nHoras de toma:");
                    for (LocalDateTime time:userMedicine.getMomentos()) {
                        paragraph.add("\n"+time.getDayOfMonth() +"-" +time.getMonthValue()+ " a las " + time.getHour()+":"+ time.getMinute());
                    }
                    paragraph.add("\nFecha de final del tratamiento" + userMedicine.getFechafinal().getDayOfMonth()+"-"+userMedicine.getFechafinal().getMonthValue()+
                            " a las " + userMedicine.getFechafinal().getHour() + ":" + userMedicine.getFechafinal().getMinute());
                    paragraph.add("\nCada: " + userMedicine.getCadahoras() + " horas\n\n");

                    document.add(paragraph);
                }

        }else {
                Paragraph paragraph=new Paragraph();
                paragraph.add("No hay datos sobre los medicamentos de " + user.getName()
                        +"\n\n");
                document.add(paragraph);
            }


        document.add(lineChunk);

        Chunk medinc = new Chunk("\n\nMedicamentos incompatibles", font);
        document.add(medinc);
        if (user.getUserMedicineIncs()!=null || user.getUserMedicineIncs().size()>0){
            for (UserMedicineInc userMedicineinc:user.getUserMedicineIncs()) {

                Paragraph paragraph=new Paragraph();
                paragraph.add("Medicamento: " + userMedicineinc.getMedicine());
                paragraph.add("\nRazón: " + userMedicineinc.getReason());
                String activo;
                if (userMedicineinc.getActive()==Boolean.TRUE){
                    activo="Sí";
                }else {
                    activo="No";
                }
                paragraph.add("\n¿Activo actualmente?:" + activo+"\n\n");
                document.add(paragraph);
            }
        }else {
            Paragraph paragraph=new Paragraph();
            paragraph.add("No hay datos sobre los medicamentos incompatibles de " + user.getName()
                    +"\n\n");
            document.add(paragraph);
        }



        document.close();
        return document;
    }
}
