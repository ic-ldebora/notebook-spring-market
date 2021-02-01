package com.market.backend.web.controller;

import com.market.backend.domain.ProductDto;
import com.market.backend.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  @ApiOperation("Get all super market products.")
  @ApiResponse(code = 200, message = "OK")
  public ResponseEntity<List<ProductDto>> getAll() {
    return new ResponseEntity<>(
        productService.getAll(),
        HttpStatus.OK
    );
  }

  @GetMapping("/{id}")
  @ApiOperation("Find a product with an ID.")
  @ApiResponses({
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 404, message = "Prooducto not found.")
  })
  public ResponseEntity<ProductDto> getProduct(
      @ApiParam(value = "The ID of the product.", required = true, example = "7")
      @PathVariable("id") Long id
  ) {
    return productService.getProduct(id)
        .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/category/{id}")
  public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable("id") Long categoryId) {
    return productService.getByCategory(categoryId)
        .map(productDtoList -> new ResponseEntity<>(productDtoList, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
    return new ResponseEntity<>(
        productService.save(productDto),
        HttpStatus.CREATED
    );
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) {

    if (Boolean.TRUE.equals(productService.delete(id))) {
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
