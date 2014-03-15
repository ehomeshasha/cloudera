package stubs;

import java.lang.reflect.Field;

public class test {

	/**
	 * @param args
	 */
	
	public String left;
	public String right;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t = new test();
		int l = t.getFieldLength();
		System.out.println(l);
		Field[] o = t.getFields();
		for(int i=0;i<o.length;i++) {
			String name = o[i].getName();
			System.out.println(name);
		}
		
	}
	
	public int getFieldLength() {
		int fieldLength = this.getClass().getFields().length;
		return fieldLength;
	}
	
	public Field[] getFields() {
		return this.getClass().getFields();
	}

}
