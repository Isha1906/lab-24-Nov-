/* @ISHA VATS
 *  create a table Grocery(id,name,price,qty) using spring boot
 * 
 * */



package com.lab.Service;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import com.lab.Entity.Grocery;

@Service
public class GroceryService {
	@Autowired
	JdbcTemplate temp;
	
	@PostConstruct
	public void execute()
	{
		
		 /* inserting values using Grocery class object */
		Grocery g=new Grocery();        
		g.setId(5);
		g.setItem_name("Strawberry");
		g.setPrice(120);
		g.setQty(20);
		
		Grocery g1=new Grocery();
		g1.setId(6);
		g1.setItem_name("Pineapple");
		g1.setPrice(60);
		g1.setQty(30);
		
		
		/* inserting values in the list */
		List<Grocery> gro=new ArrayList<>();
		gro.add(g);
		gro.add(g1);
		
		/* performing jdbc task to insert values into the database*/
		gro.forEach(a->temp.update("insert into Grocery values(?,?,?,?)",a.getId(),a.getItem_name(),a.getPrice(),a.getQty()));
		
		/* deleting from Grocery table */
		temp.update("delete from Grocery where id=5");
		
		/* updating in grocery table */
		temp.update("update Grocery set item_name='kiwi' where Id=6");
		
		/* displaying all the data of Grocery table*/
		gro=temp.query("select * from Grocery",(rs,noofrows) ->new Grocery(rs.getInt("id"),rs.getString("item_name"),rs.getInt("price"), rs.getInt("qty")));
	
		gro.forEach(s -> System.out.println("\n"+s+"\n"));
	}
}
