package ec.com.cefr.cargaarchivos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.cefr.cargaarchivos.models.CampaniaDto;
import ec.com.cefr.cargaarchivos.services.ArchivoServicio;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/api/campania/upload")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {

    @Inject
    private ArchivoServicio archivoServicio;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Part filePart = req.getPart("file");

        if (filePart == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Archivo no enviado");
            return;
        }

        try (InputStream file = filePart.getInputStream()) {
            CampaniaDto result = archivoServicio.cargarArchivo(file);
            resp.setContentType("application/json");
            resp.getWriter().write(new ObjectMapper().writeValueAsString(result));
        }
    }

}
