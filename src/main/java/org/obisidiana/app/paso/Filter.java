package org.obisidiana.app.paso;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Filter {
    private List<String> valores;
///////////////////constructor/////////////////////
    public Filter() {
    }
///////////////////get and set/////////////////////

    public List<String> getValores() {
        return valores;
    }

    public void setValores(List<String> valores) {
        this.valores = valores;
    }
}
