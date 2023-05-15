package farmappceuticos.farmappcia.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import farmappceuticos.farmappcia.model.MedicalHistory;
import farmappceuticos.farmappcia.model.User;
import farmappceuticos.farmappcia.services.UserService1;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.*;
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
}
