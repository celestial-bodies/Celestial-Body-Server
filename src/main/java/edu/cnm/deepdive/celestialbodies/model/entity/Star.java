package edu.cnm.deepdive.celestialbodies.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Star {

  @Id
  @Column(name = "star_id",
      nullable = false, updatable = false)
  private long id;

  @Column(name = "hip_id",
      nullable = false, updatable = false)
  private long hip;

  @Column(name = "hd_id",
      nullable = false, updatable = false)
  private long hd;

  @Column(name = "hr_id",
      nullable = false, updatable = false)
  private String hr;

  private String gl; // column 5

  private String bf;

  private String proper; // A common name for the star

  private double ra; // star's right ascension

  @Column(name = "star_dec")
  private double dec; // star's declination

  private double dist; // star's distance in parsecs column 10

  private double pmra; // The star's proper motion in ra, in milliarcseconds per year.

  private double pmdec; // The star's proper motion in dec, in milliarcseconds per year.

  private Double rv; //The star's radial velocity in km/sec, where known.

  private double mag;  // The star's apparent visual magnitude.

  private double absmag;  // The star's absolute visual magnitude (its apparent magnitude from a distance of 10 parsecs) column 15

  private String spect;  // The star's spectral type, if known.

  private Double ci; // The star's color index (blue magnitude - visual magnitude), where known.

  /*
  The Cartesian coordinates of the star, in a system based on the equatorial coordinates as seen from Earth
   */
  private double x; // +X is in the direction of the vernal equinox (at epoch 2000)

  private double y; // +Y in the direction of R.A. 6 hours, declination 0 degrees.

  private double z; // +Z towards the north celestial pole. Col 20.

  /*
   * The Cartesian velocity components of the star, in the same coordinate system described
   * immediately above. They are determined from the proper motion and the radial velocity (when
   * known). The Cartesian velocity components of the star, in the same coordinate system described
   * immediately above. They are determined from the proper motion and the radial velocity (when
   * known).
   */
  private Double vx;

  private Double vy;

  private Double vz;

  private double rarad;

  private double decrad; // Col 25

  private double pmrarad;

  private double pmdecrad;

  private String bayer; // A Bayer designation is a stellar designation in which a specific star is identified by a Greek or Latin letter followed by the genitive form of its parent constellation's Latin name.

  private String flam; // The Flamsteed number as a distinct value

  private String con; // The standard constellation abreviation. Col 30

  private double comp; // ID of companion star

  private double comp_primary; // ID of primary star for this component

  private String base; //  catalog ID or name for this multi-star system. Currently only used for Gliese stars.

  private double lum; // Star's luminosity as a multiple of Solar luminosity.

  private String var; // Star's standard variable star designation, when known. Col. 35

  /*
   * Star's approximate magnitude range, for variables. This value is based on the Hp magnitudes for
   * the range in the original Hipparcos catalog, adjusted to the V magnitude scale to match the
   * "mag" field.
   */
  private Double var_min;

  private Double var_max;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getHip() {
    return hip;
  }

  public void setHip(long hip) {
    this.hip = hip;
  }

  public long getHd() {
    return hd;
  }

  public void setHd(long hd) {
    this.hd = hd;
  }

  public String getHr() {
    return hr;
  }

  public void setHr(String hr) {
    this.hr = hr;
  }

  public String getGl() {
    return gl;
  }

  public void setGl(String gl) {
    this.gl = gl;
  }

  public String getBf() {
    return bf;
  }

  public void setBf(String bf) {
    this.bf = bf;
  }

  public String getProper() {
    return proper;
  }

  public void setProper(String proper) {
    this.proper = proper;
  }

  public double getRa() {
    return ra;
  }

  public void setRa(double ra) {
    this.ra = ra;
  }

  public double getDec() {
    return dec;
  }

  public void setDec(double dec) {
    this.dec = dec;
  }

  public double getDist() {
    return dist;
  }

  public void setDist(double dist) {
    this.dist = dist;
  }

  public double getPmra() {
    return pmra;
  }

  public void setPmra(double pmra) {
    this.pmra = pmra;
  }

  public double getPmdec() {
    return pmdec;
  }

  public void setPmdec(double pmdec) {
    this.pmdec = pmdec;
  }

  public Double getRv() {
    return rv;
  }

  public void setRv(Double rv) {
    this.rv = rv;
  }

  public double getMag() {
    return mag;
  }

  public void setMag(double mag) {
    this.mag = mag;
  }

  public double getAbsmag() {
    return absmag;
  }

  public void setAbsmag(double absmag) {
    this.absmag = absmag;
  }

  public String getSpect() {
    return spect;
  }

  public void setSpect(String spect) {
    this.spect = spect;
  }

  public Double getCi() {
    return ci;
  }

  public void setCi(Double ci) {
    this.ci = ci;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getZ() {
    return z;
  }

  public void setZ(double z) {
    this.z = z;
  }

  public Double getVx() {
    return vx;
  }

  public void setVx(Double vx) {
    this.vx = vx;
  }

  public Double getVy() {
    return vy;
  }

  public void setVy(Double vy) {
    this.vy = vy;
  }

  public Double getVz() {
    return vz;
  }

  public void setVz(Double vz) {
    this.vz = vz;
  }

  public double getRarad() {
    return rarad;
  }

  public void setRarad(double rarad) {
    this.rarad = rarad;
  }

  public double getDecrad() {
    return decrad;
  }

  public void setDecrad(double decrad) {
    this.decrad = decrad;
  }

  public double getPmrarad() {
    return pmrarad;
  }

  public void setPmrarad(double pmrarad) {
    this.pmrarad = pmrarad;
  }

  public double getPmdecrad() {
    return pmdecrad;
  }

  public void setPmdecrad(double pmdecrad) {
    this.pmdecrad = pmdecrad;
  }

  public String getBayer() {
    return bayer;
  }

  public void setBayer(String bayer) {
    this.bayer = bayer;
  }

  public String getFlam() {
    return flam;
  }

  public void setFlam(String flam) {
    this.flam = flam;
  }

  public String getCon() {
    return con;
  }

  public void setCon(String con) {
    this.con = con;
  }

  public double getComp() {
    return comp;
  }

  public void setComp(double comp) {
    this.comp = comp;
  }

  public double getComp_primary() {
    return comp_primary;
  }

  public void setComp_primary(double comp_primary) {
    this.comp_primary = comp_primary;
  }

  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  public double getLum() {
    return lum;
  }

  public void setLum(double lum) {
    this.lum = lum;
  }

  public String getVar() {
    return var;
  }

  public void setVar(String var) {
    this.var = var;
  }

  public Double getVar_min() {
    return var_min;
  }

  public void setVar_min(Double var_min) {
    this.var_min = var_min;
  }

  public Double getVar_max() {
    return var_max;
  }

  public void setVar_max(Double var_max) {
    this.var_max = var_max;
  }
}
