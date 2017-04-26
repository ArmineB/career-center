package com.aca.careercenter.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * @author Vahe Mkrtchyan
 */
@ManagedBean(name = "adminController", eager = true)
@SessionScoped
public class AdminController {

    public void onLoad() throws IOException {
        //todo
        FacesContext.getCurrentInstance()
                .getExternalContext().redirect("/login.xhtml");
    }

}
