package org.obisidiana.app.controller;

import org.obisidiana.app.entity.Material;
import org.obisidiana.app.entity.Product;
import org.obisidiana.app.paso.Filter;
import org.obisidiana.app.service.MaterialService;
import org.obisidiana.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.ArrayList;
import java.util.List;

@Controller

//@RequestMapping("/pages")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private MaterialService materialService;


    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index(){
        return "/index";
    }


    @RequestMapping(value = "pages/aboutus" ,method = RequestMethod.GET)
    public String aboutus(){
        return "pages/aboutus";
    }

    @RequestMapping(value = "pages/catalogo" ,method = RequestMethod.GET)
    public String catalogo(){
        return "pages/catalogo";
    }

    @RequestMapping(value = "pages/contacto" ,method = RequestMethod.GET)
    public String contacto(){
        return "pages/contacto";
    }

    @RequestMapping(value = "pages/findYourRock" ,method = RequestMethod.GET)
    public String yourRock(){
        return "pages/findYourRock";
    }

    @RequestMapping(value = "pages/filtrar" ,method = RequestMethod.GET)
    public String filtrar(Model model){
        Filter filter = new Filter();
        List<Product> productos = productService.listAllProduct();

        if(productos.isEmpty()){
            return null;
        }
        model.addAttribute("productos",productos);
        model.addAttribute("filter",filter);

        return "pages/filtrar";
    }

    @PostMapping("pages/filtrar")
    public String procesar(@ModelAttribute("filter")Filter filter, Model model)
    {
        List<Product> productos;
        if(filter.getValores().isEmpty()){
            productos = productService.listAllProduct();
        }else{
            System.out.println(filter.getValores().get(0));
            Long id = Long.valueOf(filter.getValores().get(0));
            Material material = materialService.getMaterial(id);
            List<Long> matIds = new ArrayList<>();
            matIds.add(1L);
            matIds.add(2L);
            System.out.println(matIds);
            productos = productService.findByMateriales(matIds);
        }




        model.addAttribute("productos",productos);
        model.addAttribute("filter",filter);

       // model.addAttribute("filter",filter);
        //model.addAttribute("usuario", usuario);

        return "pages/filtrar";
    }

    @GetMapping("pages/ver")
    public String ver(@ModelAttribute("filter")Filter filter, Model model, SessionStatus status) {


        System.out.println(filter.getValores().get(0));
        List<Product> productos = productService.listAllProduct();
        model.addAttribute("productos",productos);
        model.addAttribute("filter",filter);
        status.setComplete();// completa la session y elimina el usuario tambien en la base de datos
        return "pages/filtrar";
    }

    @RequestMapping(value = "pages/login" ,method = RequestMethod.GET)
    public String login(){
        return "pages/login";
    }

    @RequestMapping(value = "pages/tuPiedra" ,method = RequestMethod.GET)
    public String tuPiedra(){
        return "pages/tuPiedra";
    }
}
