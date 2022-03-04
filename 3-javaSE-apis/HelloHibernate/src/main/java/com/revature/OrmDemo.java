package com.revature;

import java.util.Arrays;
import java.util.List;

import com.revature.models.DummyOtherUser;
import com.revature.models.DummyUser;
import com.revature.util.ColumnField;
import com.revature.util.Configuration;
import com.revature.util.ForeignKeyField;
import com.revature.util.MetaModel;
import com.revature.util.PrimaryKeyField;

public class OrmDemo {
	
	public static void main(String[] args) {
		
		
		// create list of classes to pass to constructor 
		List<Class<?>> myClasses = Arrays.asList(DummyUser.class, DummyOtherUser.class);
		
		
		// build a configuration object from the ReflectionFramework
		
		
		
		// import from the com.revature.ReflectioFramework
		Configuration cfg = new Configuration();
		
		// Drawback of reflection is that it's an expensive runtime operation to inspect all the class at runtime
		cfg.addAnnotatedClasses(myClasses);
		
		System.out.println(cfg.getMetaModels()); // generate a toString() fo rhte metaModel class
		
		// iterate over each metaModel within the configruation class
		for (MetaModel<?> metaModel : cfg.getMetaModels()) {
			
			// for each one, print the information about the metaModel
			System.out.println("Printing all the MetModel info for the class %s\n" + metaModel.getClassName());
			PrimaryKeyField pk = metaModel.getPrimaryKey();
			List<ColumnField> columns = metaModel.getColumns();
//			List<ForeignKeyField> foreignKeys = metaModel.getForeignKeys();
			
			for (ColumnField cf : columns) {
				System.out.println("Found the column field named " + cf.getColumnName() + " with the type " + cf.getType());
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
