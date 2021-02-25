package com.example.Comparateur.beans;

import javax.servlet.http.HttpServletRequest;

public class RequestData {
    private String departCity;
    private String arrivalCity;
    private String dateDepart;
    private String dateReturn;
    private String classe;

    public RequestData() {

    }

    public String getDepartCity() {
        return departCity;
    }

    public void setDepartCity(String departCity) {
        this.departCity = departCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "RequestData{" +
                "departCity='" + departCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", dateDepart='" + dateDepart + '\'' +
                ", dateReturn='" + dateReturn + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }

    public RequestData(String departCity, String arrivalCity, String dateDepart, String dateReturn, String classe) {
        this.departCity = departCity;
        this.arrivalCity = arrivalCity;
        this.dateDepart = dateDepart;
        this.dateReturn = dateReturn;
        this.classe = classe;
    }
    public RequestData Getdata(HttpServletRequest request){
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String departDate = request.getParameter("depart");
        String returnDate = request.getParameter("return");
        String classType = request.getParameter("class");
        return new RequestData(from,to,departDate,returnDate,classType);
    }
}
