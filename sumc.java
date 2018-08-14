import java.util.stream.Stream;
public class sumc{
	public static void main(String args[]){
		
		//System.out.print(new ArrayList(1,2,3,4,5,6,7));
		System.out.print(Stream.of(1,2,3,4,5,6,7).reduce(0,(a,b)->a*2+b*2));
	}
}