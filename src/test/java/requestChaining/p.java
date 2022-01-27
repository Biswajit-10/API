package requestChaining;

public class p {
		public static void main(String[] args) {
			String s="muniraju muniraju";
		char[] x=s.toCharArray();
			for(int i=0;i<s.length();i++)
			{
				int count=0;
				for (int j = 0; j <i; j++) {
					if(x[j]==s.charAt(i)) {
						count++;
					}
				}
				if(count==0) {
					int c=0;
					for (int j = 0; j < x.length; j++) {
						if(s.charAt(i)==x[j]) {
							c++;
						}
					}
					System.out.println(s.charAt(i)+" "+c);
				}
			}
			
	}
}
