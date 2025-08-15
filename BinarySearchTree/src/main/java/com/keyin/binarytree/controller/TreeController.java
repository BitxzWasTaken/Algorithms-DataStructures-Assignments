package com.keyin.binarytree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.keyin.binarytree.repository.TreeRepository;
import com.keyin.binarytree.model.TreeRecord;
import com.keyin.binarytree.model.BinarySearchTree;

@Controller
public class TreeController {

    @Autowired
    private TreeRepository treeRepository;


    @GetMapping("/enter-numbers")
    public String showNumberInputForm() {
        return "enter-numbers";
    }

    @PostMapping("/process-numbers")
    @ResponseBody
    public ResponseEntity<String> processNumbers(@RequestParam String numbers) {
        try {
            List<Integer> numList = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            BinarySearchTree bst = new BinarySearchTree();
            for (int num : numList) bst.insert(num);

            ObjectMapper mapper = new ObjectMapper();
            String jsonTree = mapper.writeValueAsString(bst.getRoot());

            TreeRecord record = new TreeRecord();
            record.setInputNumbers(numbers);
            record.setTreeJson(jsonTree);
            treeRepository.save(record);

            return ResponseEntity.ok(jsonTree);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        }
    }

    @GetMapping("/previous-trees")
    public String showPreviousTrees(Model model) {
        List<TreeRecord> records = treeRepository.findAll();
        model.addAttribute("records", records);
        return "previous-trees";
    }
}