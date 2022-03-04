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

		// Drawback of reflection is that it's an expensive runtime operation to inspect
		// all the class at runtime
		cfg.addAnnotatedClasses(myClasses);

		System.out.println(cfg.getMetaModels()); // generate a toString() fo rhte metaModel class

		for (MetaModel<?> metamodel : cfg.getMetaModels()) {

			System.out.printf("Printing MetaModel for class: %s\n", metamodel.getClassName());
			PrimaryKeyField pk = metamodel.getPrimaryKey();
			List<ColumnField> columns = metamodel.getColumns();
			List<ForeignKeyField> foreignKeyFields = metamodel.getForeignKeys();

			System.out.printf(
					"\t Found a primary key field named %s, of type %s, which maps to the column with name: %s\n",
					pk.getName(), pk.getType(), pk.getColumnName());

			for (ColumnField column : columns) {
				System.out.printf(
						"\t Found a column field named %s, of type %s, which maps to the column with name: %s\n",
						column.getName(), column.getType(), column.getColumnName());
			}

			for (ForeignKeyField foreignKey : foreignKeyFields) {
				System.out.printf(
						"\t Found a foreign key field named %s, of type %s, which maps to the column with name: %s\n",
						foreignKey.getName(), foreignKey.getType(), foreignKey.getColumnName());
			}
		}
	}
}
