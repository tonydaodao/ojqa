package org.ojqa.ui.spring;

import org.ojqa.domain.util.Util;
import org.ojqa.service.BaseService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ybak
 * 
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class BaseController<T> {

    private BaseService<T> service;
    private Class<T> entityClass = (Class<T>) Util.getGenericType(getClass());
    private String typeName = entityClass.getSimpleName().toLowerCase();
    private String rootPath = "/" + typeName;

    public BaseController(BaseService<T> pService) {
        this.service = pService;
    }

    @RequestMapping("")
    public String input() {
        return rootPath + "/form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:" + rootPath + "/list";
    }

    @RequestMapping("/list")
    public ModelMap list() {
        return new ModelMap(service.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        T entity = service.get(id);
        model.addAttribute("entity", entity);
        return rootPath + "/form";
    }

    public String getTypeName() {
        return typeName;
    }

    public String getRootPath() {
        return rootPath;
    }

    public BaseService<T> getService() {
        return service;
    }

}
