package kz.iitu.FinProject.controller;

import kz.iitu.FinProject.model.Branch;
import kz.iitu.FinProject.model.City;
import kz.iitu.FinProject.repo.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/branches")
public class BranchController {
    private final BranchRepo branchRepo;

    @Autowired
    BranchController(BranchRepo branchRepo) {
        this.branchRepo = branchRepo;
        if (branchRepo.count() <= 0) {
            ArrayList<Branch> branches = new ArrayList<>();
            branches.add(new Branch("DHL", "Almas", "Almaty", 1));
            branches.add(new Branch("Pony Express", "Almas", "Almaty", 1));
            branches.add(new Branch("Alem TAT", "Almas", "Almaty", 1));
            branches.add(new Branch("EMS Kazakhstan", "Almas", "Almaty", 1));
            branches.add(new Branch("China Post", "Almas", "Almaty", 1));
            branchRepo.saveAll(branches);
        }
    }

    @GetMapping
    public String getAllBranches(Model model) {
        model.addAttribute("branches", branchRepo.findAll());
        return "branch_list";
    }

    @GetMapping("/new")
    public String newBranch(Model model) {
        model.addAttribute("branch", new City());
        return "branch_new";
    }

    @PostMapping()
    public String createBranch(@ModelAttribute("branch") Branch newBranch) {
        branchRepo.save(newBranch);
        return "redirect:/branches";
    }

    @GetMapping("/{id}/edit")
    public String editBranch(Model model, @PathVariable("id") long id) {
        model.addAttribute("branch", branchRepo.getOne(id));
        return "branch_edit";
    }

    @PostMapping("/{id}")
    public String updateBranch(@ModelAttribute("branch") Branch branch, @PathVariable long id) {
        branch.setId(id);
        branch.setChangeDate(new Date(System.currentTimeMillis()));
        branchRepo.save(branch);
        return "redirect:/branches";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        branchRepo.deleteById(id);
        return "redirect:/branches";
    }
}
