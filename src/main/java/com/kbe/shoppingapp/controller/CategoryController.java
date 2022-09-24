package com.kbe.shoppingapp.controller;
import java.util.List;

import com.kbe.shoppingapp.model.Category;
import com.kbe.shoppingapp.service.IComponentService;
import com.kbe.shoppingapp.service.ICategoryService;
import com.kbe.shoppingapp.utils.SequenceGeneratorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin
class CategoryController {

  @Autowired
  private SequenceGeneratorService sequenceGeneratorService;

  @Autowired
  private ICategoryService categoryService;

  @Autowired
  private IComponentService componentService;

  @GetMapping("/category")
  public List<Category> getCategorys() {
    return (List<Category>) this.categoryService.readAll();
  }

  @GetMapping("/category/{id}")
  public Category getCategoryById(
    @PathVariable("id") String id
  ) {
    Category category = (Category) this.categoryService.readById(id);
    return category;
  }

  @PostMapping("/category")
  Category insertCategory(@RequestBody Category category) {
    //category.setId(sequenceGeneratorService.generateSequence(Category.SEQUENCE_NAME));
    return this.categoryService.create(category);
  }

  @PatchMapping("/category/{id}")
  public Category updateCategory(@PathVariable("id") String id, @RequestBody Category category) {
    return this.categoryService.update(category, id);
  }

  @DeleteMapping("/category/{id}")
  public String deleteCategory(@PathVariable("id") String id) {
    this.categoryService.deleteById(id);

    return "deleted category: " + id;
  }

  @DeleteMapping("/category")
  public String deleteAllCategorys() {
    this.categoryService.deleteAll();

    return "deleted all category";
  }
}