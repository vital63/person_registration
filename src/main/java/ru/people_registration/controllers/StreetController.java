package ru.people_registration.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ru.people_registration.beans.Street;
import ru.people_registration.db.DataHelper;

@ManagedBean(eager = false)
@ApplicationScoped
@FacesConverter("StreetConverter")
public class StreetController implements Converter {

    private static Map<String, Street> streetMap = new TreeMap<String, Street>();

    public StreetController() {
        streetMap.clear();
        streetMap.put("", new Street());
        for(Street street: DataHelper.getInstance().getAllStreets()){
            streetMap.put(street.getName(), street);
        };
    }

    public Map<String, Street> getStreetMap() {
        return streetMap;
    }

    public void setStreetMap(Map<String, Street> streetMap) {
        this.streetMap = streetMap;
    }
    
    public List<String> getNames(){
        ArrayList<String> result = new ArrayList<>();
        return result;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return streetMap.get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Street)value).getName();
    }
}
