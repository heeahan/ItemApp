package com.example.itemapp.controller;

import com.example.itemapp.domain.Item;
import com.example.itemapp.service.ItemService;
import com.example.itemapp.repository.ItemRepository;

import io.swagger.v3.oas.annotations.*;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Item CRUD API", description = "Internship July Project, an API for item operation")
@RestController
@RequestMapping("/api")

public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @PostMapping("/items")
    @Operation(summary = "Create a new item", description = "새로운 아이템을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "아이템 추가 성공했습니다."),
            @ApiResponse(responseCode = "400", description = "아이템 정보 필요합니다."),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류 :(")
    })
    public ResponseEntity<Item> creatNewItem(@RequestBody Item item){
        try{
            if (item.getTitle() == null || item.getTitle().isEmpty()
            || item.getDescription() == null || item.getDescription().isEmpty()
            || item.getQuantity() == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Item _item = itemService.creatNewItem(item);
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("items/{id}")
    @Operation(summary = "Get the item by its id", description = "아이디로 아이템을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "아이템 조회 성공했습니다."),
            @ApiResponse(responseCode = "204", description = "해당 아이템이 없습니다."),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류 :(")
    })
    public ResponseEntity<Item> getItemById(@PathVariable("id") long id){
        try {
            Item itemData = new Item();
            itemData = itemService.getItemById(id);
            if (itemData == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(itemData, HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items")
    @Operation(summary = "Get all items", description = "모든 아이템을 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "아이템 조회 성공했습니다."),
            @ApiResponse(responseCode = "204", description = "아이템이 없습니다."),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류 :(")
    })
    public ResponseEntity<List<Item>> getAllItems(@RequestParam(required = false) String title) {
        try{
            List<Item> items = new ArrayList<Item>();
            items = itemService.getAllItems(title); // Here 호출 getAllItems From Service
            if (items.isEmpty()){ // Return Http Status
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("items/{id}")
    @Operation(summary = "Update an item", description = "아이템 정보를 수정합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "아이템 정보 수정 성공했습니다."),
            @ApiResponse(responseCode = "404", description = "NOT FOUND!")
    })
    public ResponseEntity<Item> updateItem(@PathVariable("id") long id, @RequestBody Item item){
        Item _item = itemService.updateItem(id, item);
        if (_item == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(_item, HttpStatus.OK);
        }
    }

    @DeleteMapping("items/{id}")
    @Operation(summary = "Delete an item by ID", description = "해당 아이템을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "아이템 삭제 성공했습니다."),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류 :(")
    })
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") long id){
        try{
            itemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("items/")
    @Operation(summary = "Delete all items", description = "모든 아이템을 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "모든 아이템 삭제 성공했습니다."),
            @ApiResponse(responseCode = "500", description = "내부 서버 오류 :(")
    })
    public ResponseEntity<HttpStatus> deleteAllItems(){
        try{
            itemService.deleteAllItems();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
