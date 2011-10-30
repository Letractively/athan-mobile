package com.athan.mobile;

import java.util.Locale;

import org.zkoss.util.Locales;
import org.zkoss.util.resource.Labels;
import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Html;
import org.zkoss.zul.Label;

/**
 * 
 * @author BENBOUZID
 */
public class HelloViewCtrl extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;

	private Label lblGreetings;
	private Button btnFR;
	private Button btnEN;

	private int i = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		if (lblGreetings != null) {
			lblGreetings.setValue("postValue");
		}

		Html html = new Html();
		html.setContent("<div id=\"saad\">Hello !!</div>");
		html.setParent(comp);
		
//		Labels.reset();
		
		Clients.alert("1. " + Locales.getCurrent().getCountry());
		Clients.alert("2. " + Locales.getCurrent().getLanguage());
		Clients.alert("3. " + Labels.getLabel("monlabel"));

	}

	public void onClick$btnHi() {
		lblGreetings.setValue("" + (i++));
		Clients.evalJavaScript("ecrire(" + i + ")");
	}
	
	public void onClick$btnEN() {
		session.setAttribute(Attributes.PREFERRED_LOCALE, Locale.ENGLISH);
		StringBuffer sb = new StringBuffer();
		sb.append("\nA. " + Labels.getLabel("monlabel"));
		//Labels.reset();
//		sb.append("\nB. " + Labels.getLabel("monlabel"));
		Executions.sendRedirect(""); //reload the same page
		sb.append("\nC. " + Labels.getLabel("monlabel"));
		Clients.alert(sb.toString());
	}
	
	public void onClick$btnFR() {
		session.setAttribute(Attributes.PREFERRED_LOCALE, new Locale("fr","FR"));
		StringBuffer sb = new StringBuffer();
		sb.append("\nA. " + Labels.getLabel("monlabel"));
		//Labels.reset();
//		sb.append("\nB. " + Labels.getLabel("monlabel"));
		Executions.sendRedirect(""); //reload the same page
		sb.append("\nC. " + Labels.getLabel("monlabel"));
		Clients.alert(sb.toString());
	}

}