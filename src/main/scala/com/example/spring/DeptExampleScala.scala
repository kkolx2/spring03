package com.example.spring

object DeptExampleScala {
	def main(args: Array[String]): Unit = {
		var dept : Dept = new Dept(10, "xxx", "yyy");

		println(dept);
		dept.print();
		dept.print2();
		println(dept.deptno + dept.dname);
	}
}