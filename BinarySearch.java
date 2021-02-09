package pack;
import java.util.ArrayList;

class BinarySearch { 

 static public int binarySearch_facultate(ArrayList <Facultate> facultati, int l, int r, String x) 
 { 
     if (r >= l) { 
         int mid = l + (r - l) / 2; 

         if (facultati.get(mid).getNume() == x) 
             return mid; 

         int chr=0;
         if (facultati.get(mid).getNume().charAt(0) == x.charAt(0))
         {      
        	 while(facultati.get(mid).getNume().charAt(chr) == x.charAt(chr))
        	 {
        		 chr++;
        	 }
         }
         
         if (facultati.get(mid).getNume().charAt(chr) > x.charAt(chr)) 
             return binarySearch_facultate(facultati, l, mid - 1, x); 

         
         return binarySearch_facultate(facultati, mid + 1, r, x); 
     } 

     return -1; 
 }
 
 static public int binarySearch_spec(ArrayList <Specializare> specializari, int l, int r, String x) 
 { 
     if (r >= l) { 
         int mid = l + (r - l) / 2; 

         if (specializari.get(mid).getNume_spec() == x) 
             return mid; 

         int chr=0;
         if (specializari.get(mid).getNume_spec().charAt(0) == x.charAt(0))
         {      
        	 while(specializari.get(mid).getNume_spec().charAt(chr) == x.charAt(chr))
        	 {
        		 chr++;
        	 }
         }
         
         if (specializari.get(mid).getNume_spec().charAt(chr) > x.charAt(chr)) 
             return binarySearch_spec(specializari, l, mid - 1, x); 

         
         return binarySearch_spec(specializari, mid + 1, r, x); 
     } 

     return -1; 
 }
 
 
 static public int binarySearch2_facultate(ArrayList <Facultate> facultati, String x)
 {
	 int i;
	 int chr=0;
	 for(i=0; i<facultati.size(); i++)
	 {
		 if(facultati.get(i).getNume().charAt(0)==x.charAt(0))
				 {
			 while(facultati.get(i).getNume().charAt(chr)==x.charAt(chr))
				 chr++;
				 }
		 if(facultati.get(i).getNume().charAt(chr)<x.charAt(chr))
			 continue;
		 else return i;
	 }
	 
	 return i;
 }
 
 static public int binarySearch2_spec(ArrayList <Specializare> specializari, String x)
 {
	 int i;
	 int chr=0;
	 for(i=0; i<specializari.size(); i++)
	 {
		 if(specializari.get(i).getNume_spec().charAt(0)==x.charAt(0))
				 {
			 while(specializari.get(i).getNume_spec().charAt(chr)==x.charAt(chr))
				 chr++;
				 }
		 if(specializari.get(i).getNume_spec().charAt(chr)<x.charAt(chr))
			 continue;
		 else return i;
	 }
	 
	 return i;
 }

}
