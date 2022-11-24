package com.lab.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grocery {
	
	private int id;
	private String item_name;
	private int price;
	private int qty;

}
