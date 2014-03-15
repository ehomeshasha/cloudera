package stubs;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

public class StringPairWritable implements WritableComparable<StringPairWritable> {
	
	public String left;
	public String right;
	
	
	
	
	
	
	public StringPairWritable() {
		
	}
	
	public StringPairWritable(String left, String right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	public String getLeft() {
		return left;
	}
	
	public void setLeft(String left) {
		this.left = left;
	}
	
	public String getRight() {
		return right;
	}
	
	public void setRight(String right) {
		this.right = right;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringPairWritable other = (StringPairWritable) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "StringPairWritable [left=" + left + ", right=" + right + "]";
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		Class<?> c = this.getClass();
		int count = c.getFields().length;
		WritableUtils.writeVInt(out, count);
		Field[] f = c.getFields();
		for(int i=0;i<count;i++) {
			try {
				out.writeUTF(f[i].get(this).toString());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		//out.writeUTF(this.left);
		//out.writeUTF(this.right);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		Class<?> c = this.getClass();
		Field[] f = c.getFields();
		int count = WritableUtils.readVInt(in);
		for(int i=0;i<count;i++) {
			try {
				f[i].set(this, in.readUTF());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		//this.left = in.readUTF();
		//this.right = in.readUTF();
	}

	@Override
	public int compareTo(StringPairWritable o) {
		// TODO Auto-generated method stub
		
		Class<?> c = this.getClass();
		Field[] f = c.getFields();
		int count = c.getFields().length;
		if(count > 1) {
			int ret = f[0].get(o).toString().compareTo(f[0].get(this).toString());
		} else {
			return 0;
		}
		for(int i=0;i<count;i++) {
			try {
				f[i].get(o).toString().compareTo(f[i].get(this).toString()
					
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		int ret = left.compareTo(o.left);
	    if (ret == 0) {
	      return right.compareTo(o.right);
	    }
	    return ret;
	}
	
	

}
