package com.hand.api.servlet;

import com.hand.api.service.impl.PersonServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet",urlPatterns = "/deletePerson")
public class PersonServlet extends HttpServlet {
    // 实例化
    private PersonServiceImpl personService=new PersonServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");

        personService.deletePerson(Integer.valueOf(id));

        PrintWriter out=resp.getWriter();
        out.print("Delete person end");
    }
}
