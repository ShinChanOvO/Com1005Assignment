
/**
 * Coords.java
 *
 * Phil Green 2018 version Heidi Christensen 2021 version
 * 
 * a coordinate pair (y,x) for use in Ramblers problems to plot solution paths
 * on TerrainMaps
 */

public class Coords {
  private int x;
  private int y;

  /**
   * constructor, given y & x
   */

  public Coords(int yin, int xin) {
    x = xin;
    y = yin;
  }

  public int getx() {
    return x;
  };

  public int gety() {
    return y;
  }

//override the hashCode and equals method

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + x;
	result = prime * result + y;
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
	Coords other = (Coords) obj;
	if (x != other.x)
		return false;
	if (y != other.y)
		return false;
	return true;
};

}
