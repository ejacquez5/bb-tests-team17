package cs5387;

public class TableSorter {
	static int operationCount;

	public static void main(String[] args) throws Exception {
		operationCount = 0;
		
		Table t1 = Table.GetTable("src\\Test_1.txt");                                                             
		System.out.println("Table before sorting" +"\n" + t1.toString());
		operationCount += 4;                                                     //assignment statements in lines 7,9 and function calls in lines 9,8
		
		if (!isSorted(t1)) {
			sortable(t1);
			System.out.println("Table after sorting" +"\n" + t1.toString());
			operationCount += 3;                                                  //function calls in lines 13-15
		}
		
		System.out.println("Total number of operations is: " + operationCount);
	}

	public static boolean isSorted(Table t) {
		for (int i = 0; i < t.getSize(); i++) {
			int previousValue = t.getTableValue(i, 0);
			operationCount += 6;                                      //assignment statement, comparison operation, branch, and function call in line 23, and assignment operation and function call in line 24
			for (int j = 1; j < t.getSize(); j++) {
				operationCount += 4;                                  //assignment statement, comparison operation, branch, and function call in line 27
				if (previousValue > t.getTableValue(i, j)) {
					operationCount += 4;                              //assignment statement, comparison operation, branch, and function call in line 28
					return false;
				}
				previousValue = t.getTableValue(i, j);
				operationCount += 3;                                  //assignment statement, function call and branch in line 32
			}
			operationCount += 1;                                      //branch in line 34
		}
		operationCount += 1;                                          //branch in line 35
		return true;
	}

	public static void sortable(Table t) { 
		for (int i = 0; i < t.getSize(); i++) {
			operationCount += 4;                                    //assignment statement, comparison operation, branch, and function call in line 42
			for (int j = 0; j < t.getSize(); j++) {
				operationCount += 4;                                //assignment statement, comparison operation, branch, and function call in line 44
				for (int k = 0; k < t.getSize(); k++) {
					operationCount += 4;                            //assignment statement, comparison operation, branch, and function call in line 46
					if (k > 0 && t.getTableValue(k - 1, t.getSize() - 1) > t.getTableValue(k, 0)) {
						int tempValue = t.getTableValue(k, 0); 
						t.setTableValue(k, 0, t.getTableValue(k - 1, t.getSize() - 1)); 
						t.setTableValue(k - 1, t.getSize() - 1, tempValue); 
						operationCount += 14;                       //comparison operations, function calls, and branch in line 48, assignment statement in line 49, and function calls in line 49-51
					}
					operationCount += 1;                            //branch in line 53
					for (int l = 0; l < t.getSize() - 1; l++) {
						operationCount += 4;                        //assignment statement, comparison operation, branch, and function call in line 55
						
						if (t.getTableValue(k, l) > t.getTableValue(k, l + 1)) { //3
							int tempValue = t.getTableValue(k, l);
							t.setTableValue(k, l, t.getTableValue(k, l + 1));
							t.setTableValue(k, l + 1, tempValue);
							operationCount += 9;                    //comparison operation, branch, and function calls in line 58, assignment statement in line 59, and function calls in lines 59-61
						}
						operationCount += 1;                        //branch in line 63
					}
					operationCount += 1;                            //branch in line 65
				}
				operationCount += 1;                                //branch in line 67
			}
			operationCount += 1;                                    //branch in line 69
		}
		operationCount += 1;                                        //branch in line 71
	}
}
