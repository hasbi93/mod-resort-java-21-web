package com.acme.modres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.text.StringEscapeUtils;

@WebServlet("/resorts/upper")
public class UpperServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String originalStr = request.getParameter("input");
        if (originalStr == null) {
            originalStr = "";
        }

        String newStr = originalStr.toUpperCase();
        newStr = StringEscapeUtils.escapeHtml4(newStr);

        PrintWriter out = response.getWriter();
        out.print("<br/><b>capitalized input: " + newStr + "</b>");
    }
}