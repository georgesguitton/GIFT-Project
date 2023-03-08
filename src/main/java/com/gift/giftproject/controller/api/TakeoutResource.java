package com.gift.giftproject.controller.api;


import com.gift.giftproject.controller.service.StudentService;
import com.gift.giftproject.controller.service.TutorService;
import com.gift.giftproject.view.ExcelOneView;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Path("/takeout")
@RolesAllowed("tutor_role")
public class TakeoutResource {
    @Inject
    TutorService tutorService;

    @Inject
    StudentService studentService;

    @GET
    @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public Response getMyData(@Context HttpServletRequest request) {
        final var tutor = tutorService.getTutorByEmail(request.getRemoteUser());
        final var tutorStudents = studentService.getTutorStudents(tutor, null);

        final var timestamp = LocalDateTime.now();
        final var filename = "Student list_" + timestamp.format(DateTimeFormatter.ISO_DATE_TIME) + ".xlsx";

        final var stream = new StreamingOutput() {
            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                try (var excelWorkbook = new ExcelOneView(tutorStudents).render()) {
                    excelWorkbook.write(outputStream);
                }
            }
        };

        return Response.ok(stream)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + filename)
                .build();
    }
}
