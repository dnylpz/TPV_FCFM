package com.fcfm.tienda.servlets;

import com.fcfm.tienda.models.Video;
import com.fcfm.tienda.services.VideoDAO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URL;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jose.espinoza.lopez on 11/24/2015.
 */
@WebServlet(name = "videoServlet",
            urlPatterns = "/vid")
@MultipartConfig
public class videoServlet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "/videos";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("entro al vid");
        Part vid1 = request.getPart("vidName");
        Part vidDef = request.getPart("defVidName");
        ServletContext sc = request.getServletContext();
        Date vig = new Date();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            vig = sdf.parse(request.getParameter("vigencia"));
        }catch(Exception e){
            e.printStackTrace();
        }
        String basePath = sc.getRealPath("/videos");
        if(!vidDef.getSubmittedFileName().equals("")) {
            String fileName2 = vidDef.getSubmittedFileName();
            InputStream is2 = vidDef.getInputStream();
            try {
                File b = new File(basePath + File.separator + fileName2);
                Files.copy(is2, b.toPath());
                String tipo = Files.probeContentType(b.toPath());
                Video def = new Video(0, b.getName(), b.getPath(), null, tipo);
                VideoDAO.updateDefault(def);
                request.getSession().setAttribute("vidDef", def);
            }catch(FileAlreadyExistsException faee){
                faee.printStackTrace();
            }
        }
        if(!vid1.getSubmittedFileName().equals("")) {
            String fileName1 = vid1.getSubmittedFileName();
            InputStream is1 = vid1.getInputStream();
            try {
                File a = new File(basePath + File.separator + fileName1);
                Files.copy(is1, a.toPath());
                String tipo = Files.probeContentType(a.toPath());
                Video a1 = new Video(0, a.getName(), "videos/"+a.getName(), vig, tipo);
                VideoDAO.saveVideo(a1);
                request.getSession().setAttribute("vid", VideoDAO.getVideo());
            }catch(FileAlreadyExistsException faee){
                faee.printStackTrace();
            }
        }

        request.getRequestDispatcher("admon.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
