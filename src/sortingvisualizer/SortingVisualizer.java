/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sortingvisualizer;

/**
 *
 * @author khalid hasan
 */
public class SortingVisualizer {
    public static Thread sortingThread;

   
  


	public static VisualizerFrame frame;
	public static Integer[] toBeSorted;
	public static boolean isSorting = false;
	public static int sortDataCount = 50;
	public static int sleep = 420;
	public static int blockWidth;
        public static boolean paused = false; 
	
	public static void main(String[] args) {
                 
            
          // new Welcome();
           
		frame = new VisualizerFrame();
                
		resetArray();
		frame.setLocationRelativeTo(null);
	}
	public static void resetArray(){
		if (isSorting==true){ 
                    return;
                }
		toBeSorted = new Integer[sortDataCount];
		blockWidth = (int) Math.max(Math.floor(500/sortDataCount), 1);
		for(int i = 0; i<toBeSorted.length; i++){
		
				toBeSorted[i] = (int) (sortDataCount*Math.random());
                                System.out.println(""+toBeSorted[i]);
                                 System.out.println("--------------------------------------------------");
			}
                for(int i = 0; i<toBeSorted.length; i++){
                if(toBeSorted[i]==0){
                    toBeSorted[i]=toBeSorted[i]+1;
                }
                }
                 for(int i = 0; i<toBeSorted.length; i++){
                 System.out.println(""+toBeSorted[i]);}
                
                
		frame.preDrawArray(toBeSorted);
	}
       public static void startSort(String type){

		if ( !isSorting){

			resetArray();
			isSorting = true;

			switch(type){
			case "Bubble":
				sortingThread = new Thread(new BubbleSort(toBeSorted, frame));
				break;

			case "Selection":
				sortingThread = new Thread(new SelectionSort(toBeSorted, frame));
				break;

			case "Insertion":
				sortingThread = new Thread(new InsertionSort(toBeSorted, frame));
				break;

			case "Merge":
				sortingThread = new Thread(new MergeSort());
				break;

			default:
				isSorting = false;
				return;
			}
	sortingThread.start();
                }}
                public static void stopSort(){
       //     System.Exit(0);
       paused = !paused;
       System.out.println(paused);
        if (paused == false){
                                    synchronized(sortingThread)
                {
                    
                    sortingThread.notify();
                }
//       if(paused == true)
//                        {
//                           
//                            synchronized(sortingThread)
//                            {
//                                // Pause
//                                try 
//                                {sortingThread.wait();
//                                } 
//                                catch (InterruptedException e) 
//                                {
//                                }
//                            }
//                        }
       
//       synchronized(sortingThread)
//                {
//                    
//                    sortingThread.notify();
//                }
       
}
// public static void resume(){       
//   
//       synchronized(sortingThread)
//                {
//                    
//                    sortingThread.notify();
//                }
//       
//    
// }
   }
    
}
