import java.lang.Math;
import java.util.Arrays;
public class Maths{
	
	//static double[] smallsample = {71.8, 58.6, 54.6, 51.9, 49.7, 47.6, 44.9, 36.9};
	//static double[] smallsample = {1, 2, 3, 4, 5, 0, 0.0};
	/*static double[] avaliablechampions = {71.7, 71.1, 65.6, 65.0, 62.7, 62.4, 62.3, 62.0, 61.9, 61.4, 61.1, 60.6, 59.9, 59.70002, 59.70001, 59.7,
										59.2, 59.10001, 59.1, 58.60001, 58.6, 58.3, 58.2, 57.4, 57.20001, 57.2, 57.1, 56.9, 56.8, 56.3, 56.1, 56.00001, 56.0,
										55.9, 55.3, 55.10001, 55.1, 55.0, 54.6, 54.4, 53.8, 53.7, 53.5, 53.4, 53.30001, 53.3, 53.20001, 53.2, 53.1, 52.9,
										52.8, 52.6, 52.5, 52.40001, 52.4, 52.30002, 52.30001, 52.3, 52.10001, 52.1, 51.7, 51.6, 51.3, 51.1, 51.00001, 51.0, 50.90001,
										50.9, 50.8, 50.7, 50.6, 50.5, 50.4, 50.00002, 50.00001, 50.0, 49.9, 49.80003, 49.80002, 49.80001, 49.8, 49.70001, 49.7, 49.6,
										49.3, 49.2, 48.9, 48.60001, 48.6, 48.5, 48.40001, 48.4, 48.30001, 48.3, 48.10001, 48.1, 48.0, 47.8, 47.70001, 47.7, 47.6,
										47.3, 47.20002, 47.20001, 47.2, 47.1, 47.00002, 47.00001, 47.0, 46.70001, 46.7, 46.50001, 46.5, 46.4, 46.1, 46.00001, 46.0, 45.7,
										45.6, 45.0, 44.9, 44.5, 44.4, 44.3, 44.2, 44.0, 43.9, 43.6, 43.3, 43.1, 42.5, 42.20001, 42.2, 42.0, 41.6,
										41.3, 40.5, 40.2, 38.3, 37.0, 36.6
										 };
										 */
	//taken from lolalytics 11/17/18 i have to slightly fudge the numbers to make duplicate wrs count as unique champions
	static double[] avaliablechampions = {71.51, 70.34, 67.28, 65.89, 65.74, 64.310001, 64.31, 63.52, 62.01, 61.72, 60.9, 60.77, 60.31, 60.14, 60.08, 59.88, 58.79,
										58.73, 58.69, 58.66, 58.27, 58.14, 57.49, 57.35, 57.14, 56.930001, 56.93, 56.6, 56.13, 56.1, 56.08, 56.04, 55.84, 55.63,
										55.61, 54.95, 54.91, 54.88, 54.81, 54.78, 54.63, 54.61, 54.46, 54.45, 54.4, 54.36, 54.33, 54.29, 54.07, 54.05, 53.83, 53.83,
										53.72, 53.66, 53.12, 52.64, 52.6, 52.38, 52.3, 52.27, 52.05, 51.88, 51.41, 51.38, 51.32, 51.12, 50.76, 50.34, 50.0002, 50.0001,
										50, 49.89, 49.8, 49.7, 49.37, 49.25, 49.19, 49.14, 49.05, 48.78, 48.72, 48.65, 48.48, 48.42, 48.29, 48.26, 48.14, 48.05, 48.03,
										48.02, 47.83, 47.37, 46.79, 46.59, 46.56, 46.49, 46.3, 46.26, 46.09, 45.67, 45.52, 45.43, 45.34, 44.94, 44.440001, 44.44, 44.39,
										44.32, 44.23, 43.96, 43.82, 43.62, 43.43, 43.27, 42.33, 42.06, 41.92, 41.18, 40.89, 40.29, 40.25, 40.19, 39.85, 39.8, 39.53, 39.48,
										39.46, 38.54, 37.5, 36.63, 36.02, 35.32, 34.05, 30, 29.17
										};
	//taken from high mmr wr getting rid of champions who have been reworked 3/27/18

	//Simulate a champion rotation randomly, making sure to not double pick champions
	public static void rotationarray(int rotationsize, double[] retlist, double [] Champlist){
		int i; int i2;
		double temp;
		for(i = 0; i < rotationsize+1; i++){
			temp = Champlist[(int)Math.floor(Math.random() * Champlist.length)];
				for (i2 = 0; i2 < i; i2++) {
					if(retlist[i2] == temp){
						i -= 1;
						break;
					}
					if(i2 == i-1){
						retlist[i2] = temp;
					}
				}
		}	
	}

	//make an array full of champion rotations
	//this is the best i'm going to get
	public static void rotationarrayarray(int rotationsize, double[][] retlist, double [] Champlist){
		int i;
		for(i = 0; i < retlist.length; i++){
			rotationarray(rotationsize, retlist[i], Champlist);
		}
	}

	//calculate the average wr of a pool
	public static double arraywr(double[] inputarray){
		double retdouble = 0;
		int i; int reallength;
		reallength = numbernonzeroelements(inputarray);
		for(i = 0; i < inputarray.length; i++){
			retdouble += inputarray[i]/(double)reallength;
		}
		return retdouble;
	}

	public static double avgarraywr(double[][] inputarrayarray){
		double retdouble = 0;
		int i;
		for(i = 0; i < inputarrayarray.length; i++){
			retdouble += arraywr(inputarrayarray[i])/(double)inputarrayarray.length;
		}
		return retdouble;
	}

	//adds two arrays together but doesn't add nonunique elements assumes that the first arrays is atleast a set
	public static void setaddition(double[] set1, double[] set2, double[] retset){
		int i; int i2; int i3;
		i3 = 0;
		for (i = 0; i < set1.length; i++) {
			retset[i] = set1[i];
		}
		//System.out.println(Arrays.toString(retset));
		for (i = 0; i < set2.length; i++) { 
			for (i2 = 0; i2 < set1.length; i2++) {
				if(set2[i] == set1[i2]){
					break;
				}	
				if(i2 == set1.length - 1){
					retset[set1.length + i3] = set2[i];
					i3++;
					//System.out.println(Arrays.toString(retset));
				}
			}
		}
	}

	public static int numbernonzeroelements(double[] set){
		int i; 
		int retint = 0;
		for(i = 0; i < set.length; i++){
			if(set[i] != 0.0){
				retint++;
			}
		}
		return retint;
	}

	public static void allpoolwr(double[] pool, int rotations, int rotchamps){
		int i; int i2;
		double[] movingpool = new double[150];
		double[][] rotationpool = new double[rotations][rotchamps];
		rotationarrayarray(rotchamps, rotationpool, pool);
		double[] temp = new double[300];//keep this number > movingpool because of setaddition
		double tempwr = 0.0;
		double highestwr = 0.0;
		int bestpool = 0;
		for(i = 0; i < pool.length; i++){
			movingpool[i] = pool[i];
			// System.out.println(i);
			for(i2 = 0; i2 < rotations; i2++){
			//	System.out.println(Arrays.toString(rotationpool[i2]));
				setaddition(movingpool, rotationpool[i2], temp);
				tempwr += arraywr(temp)/rotationpool.length;
				//System.out.println(numbernonzeroelements(temp));
				//System.out.println(Arrays.toString(temp));
			}
			if(tempwr > highestwr){
				bestpool = numbernonzeroelements(movingpool);
				highestwr = tempwr;
			}
			/*
			System.out.println(numbernonzeroelements(movingpool));
			System.out.println(tempwr);
			System.out.println("\n");
			*/
			tempwr = 0.0;
		}
		System.out.println("Bestpool");
		System.out.println(bestpool);
		System.out.println(highestwr);
	}

	
	public static void main(String[] args){
	/*	
		//rotationarray test
		double[] temp = new double[5];
		rotationarray(3, temp, smallsample);
		System.out.println(Arrays.toString(temp));
	*/
	/*
		//rotationarrayarray test
		double[][] temp = new double[10][3];
		rotationarrayarray(3, temp, smallsample);
		int i;
		for( i = 0; i < temp.length; i++){
			System.out.println(Arrays.toString(temp[i]));
		}	
	*/
    /*
    	//arraywr test
    	double[] temp = {1, 2, 3, 0.0, 0};
    	System.out.println(arraywr(temp));
    	System.out.println(arraywr(smallsample));
	*/
    /*
		//avgarraywr test
		double[][] temp = new double[2][3];
		rotationarrayarray(3, temp, smallsample);
		int i;
		for( i = 0; i < temp.length; i++){
			System.out.println(Arrays.toString(temp[i]));
		}	
		System.out.println(avgarraywr(temp));
	*/
	/*
		//setaddition test
		double[] temp = {3, 4, 4, 4.0, 242, 1};
		double[] temp2 = {1,  3, 2, 5, 4.0, 4, 242};
		double[] temp3 = new double[15];
		setaddition(temp, temp2, temp3);
		System.out.println(Arrays.toString(temp3));
	*/
	/*
		//numbernonzeroelements test
		double[] temp = {0.0, 4, 2.4, 0.0, 12, 0.0};
		System.out.println(numbernonzeroelements(temp));
	*/
	allpoolwr(avaliablechampions, 100000, 42);
	//27 - 35 for 42 53.85~ 27 seems to be the best across the highest sample size
	//23 56.9 notably there is a full 0.7 percent drop btwn champions 23 and 24
	//highmmr says 22 for both
	//around 58 percent wr
	}


}		