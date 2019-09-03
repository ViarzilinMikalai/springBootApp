package by.itstep.viarzilin.controller;

import by.itstep.viarzilin.domain.Car;
import by.itstep.viarzilin.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public String listOfCars(
            Model model,
            @RequestParam (required = false, defaultValue = "") Car editCar,
            @RequestParam (required = false, defaultValue = "") Car removeCar,
            @RequestParam (required = false, defaultValue = "") Car repareCar,
            @PageableDefault(sort = {"mark"},direction = Sort.Direction.ASC) Pageable pageable
            ){

        Page<Car> page = carService.getAll(pageable);
        model.addAttribute("url", "/cars");
        model.addAttribute("page", page);

        /*
        Edit exists Car
         */
        if (editCar != null) {
            model.addAttribute("car", editCar);
        }

        /*
        Remove exists Car
         */
        if (removeCar != null){
            carService.remove(removeCar);
        }

        /*
            Repare deleted car
         */
        if (repareCar != null){
            carService.repareCar(repareCar);
        }

        return "cars";
    }


    @PostMapping
    public String addOrUpdateCar(
            @Valid Car car,
            BindingResult bindingResult,
            Model model,
            @PageableDefault(sort = {"mark"},direction = Sort.Direction.ASC) Pageable pageable
    ){
        Page<Car> page = carService.getAll(pageable);
        model.addAttribute("url", "/cars");
        model.addAttribute("page", page);

        if (bindingResult.hasErrors()){

            model.addAttribute("page", page);
            Map <String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("car", car);

            return "cars";
        } else {

            if (carService.saveCar(car)){

                return "redirect:cars";

            } else {
                model.addAttribute("page", page);
                model.addAttribute("savingReport", "Car with such VIN is exists!");
                model.addAttribute("car", car);

                return "cars";
            }
        }
    }
}
