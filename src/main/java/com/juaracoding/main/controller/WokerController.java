package com.juaracoding.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juaracoding.main.model.DepartementData;
import com.juaracoding.main.model.DepartementRowMapper;
import com.juaracoding.main.model.Worker;
import com.juaracoding.main.model.WorkerRowMapper;

@RestController
@RequestMapping("/worker")
public class WokerController {

	
	
	@Autowired
	JdbcTemplate jdbc ;
	
//Tampilkan 5 gaji terbesar


public List<Worker> getWorker_id() {
	

	String sql = "SELECT worker_id,salary,first_name,last_name,departement,joining_date FROM worker ORDER BY salary DESC LIMIT 5";
	
	
	
	List <Worker> worker =  jdbc.query(sql,new WorkerRowMapper());

	return worker;
}

@GetMapping("/")

public List<Worker> list() {
return getWorker_id();
}


//end gaji terbesar


//mencari gaji yang sama

public List<Worker> getWorker_id1() {
	

	String sql = "SELECT * FROM worker where salary IN (SELECT salary  FROM worker GROUP BY salary HAVING count(*) > 1)";
	
	
	
	List <Worker> worker =  jdbc.query(sql,new WorkerRowMapper());

	return worker;
}

@GetMapping("/sama")

public List<Worker> list1() {
return getWorker_id1();
}

//end mencari gaji yang sama


//memasukkan data
	public int insertWorker(Worker worker) {
		
		return jdbc.update("insert into Worker(worker_id, first_name, last_name, salary, joining_date, departement) values (" + worker.getWorker_id() + ",'"
				+ worker.getFirst_name() + "','" + worker.getLast_name() + "','" + worker.getSalary() + "','" + worker.getJoining_date() +"','" + worker.getDepartement() +"')");

	}
	
	
	@PostMapping("/")
    public String add(@RequestBody Worker worker) {


		if (this.insertWorker(worker) == 1) {
			return "Insert data berhasil";
		} else {
			return "Insert data gagal";
		}
    }

	
	
//end memasukkan data	

	
	
// update data
	public int updateWorker(String worker_id, Worker worker) {

	return jdbc.update("UPDATE Worker SET `first_name`='"+ worker.getFirst_name() +"', `last_name`='"+ worker.getLast_name() +"',`salary`='"+ worker.getSalary() +"', `joining_date`='"+ worker.getJoining_date() +"', `departement`= '"+ worker.getDepartement() +"'  where `worker_id`= '" + worker.getWorker_id()+"'"); 
	
	
	}
	
	 @PutMapping("/{worker_id}")
	    public ResponseEntity<?> update(@RequestBody Worker worker, @PathVariable String worker_id) {
		 try {
	            updateWorker(worker_id, worker);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	 }
	 
// end update data	 
	 
	 
	 
//hapus data	 
	public int deleteWorker(String worker_id) {
			return jdbc.update("DELETE FROM `Worker` WHERE `worker_id` = '" + worker_id + "';");
		}


	 @DeleteMapping("/{worker_id}")
	    public void delete(@PathVariable String worker_id) {
		 	deleteWorker(worker_id);
	 }
//end hapus data
	
	 
	 
	 
//count departement
	 
	 
	 @GetMapping("/count1")
	    public List<DepartementData> lstKpr(@RequestBody DepartementData data) {
		 
	    	 //String sql = " CALL `Countdepartement`('"+data.getTotalkryawan()+"')";

		 	String sql= "SELECT departement, COUNT(departement) AS jumlah FROM worker GROUP BY departement";
		 
			List<DepartementData> departement = jdbc.query(sql, new DepartementRowMapper());

			return departement;
			
	    }
	 
	 public List<Worker> getWorker_id2() {
			

			String sql = "SELECT * FROM worker where Departement IN (SELECT departement  FROM worker GROUP BY departement HAVING count)";
			
			
			
			List <Worker> worker =  jdbc.query(sql,new WorkerRowMapper());

			return worker;
		}

		@GetMapping("/count")

		public List<Worker> list2() {
		return getWorker_id1();
		}

//end count departement
	
}
