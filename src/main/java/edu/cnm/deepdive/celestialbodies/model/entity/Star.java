package edu.cnm.deepdive.celestialbodies.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Defines a database entity and REST resource representing the attributes of a star.
 */
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

  /**
   * Returns the database primary key
   *
   * @return id database primary key
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the database primary key
   *
   * @param id database primary key
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns The star's ID in the Hipparcos catalog, if known.
   *
   * @return hip the star's ID in the Hipparcos catalog, if known.
   */
  public long getHip() {
    return hip;
  }

  /**
   * Sets the star's ID in the Hipparcos catalog, if known.
   *
   * @param hip the star's ID in the Hipparcos catalog, if known.
   */
  public void setHip(long hip) {
    this.hip = hip;
  }

  /**
   * Returns the star's ID in the Henry Draper catalog, if known.
   *
   * @return hd the star's ID in the Henry Draper catalog, if known.
   */
  public long getHd() {
    return hd;
  }

  /**
   * Sets the star's ID in the Henry Draper catalog, if known.
   *
   * @param hd the star's ID in the Henry Draper catalog, if known.
   */
  public void setHd(long hd) {
    this.hd = hd;
  }

  /**
   * Returns the star's ID in the Harvard Revised catalog, which is the same as its number in the
   * Yale Bright Star Catalog.
   *
   * @return hr the star's ID in the Harvard Revised catalog, which is the same as its number in the
   * Yale Bright Star Catalog.
   */
  public String getHr() {
    return hr;
  }

  /**
   * Sets the star's ID in the Harvard Revised catalog, which is the same as its number in the Yale
   * Bright Star Catalog.
   *
   * @param hr the star's ID in the Harvard Revised catalog, which is the same as its number in the
   * Yale Bright Star Catalog.
   */
  public void setHr(String hr) {
    this.hr = hr;
  }

  /**
   * Returns the star's ID in the third edition of the Gliese Catalog of Nearby Stars.
   *
   * @return gl the star's ID in the third edition of the Gliese Catalog of Nearby Stars.
   */
  public String getGl() {
    return gl;
  }

  /**
   * Sets the star's ID in the third edition of the Gliese Catalog of Nearby Stars.
   *
   * @param gl the star's ID in the third edition of the Gliese Catalog of Nearby Stars.
   */
  public void setGl(String gl) {
    this.gl = gl;
  }

  /**
   * Returns The Bayer / Flamsteed designation, primarily from the Fifth Edition of the Yale Bright
   * Star Catalog. This is a combination of the two designations. The Flamsteed number, if present,
   * is given first; then a three-letter abbreviation for the Bayer Greek letter; the Bayer
   * superscript number, if present; and finally, the three-letter constellation abbreviation.
   *
   * @return bf the Bayer / Flamsteed designation.
   */
  public String getBf() {
    return bf;
  }

  /**
   * Sets the Bayer / Flamsteed designation.
   *
   * @param bf the Bayer / Flamsteed designation.
   */
  public void setBf(String bf) {
    this.bf = bf;
  }

  /**
   * Returns a common name for the star.
   *
   * @return proper a common name for the star.
   */
  public String getProper() {
    return proper;
  }

  /**
   * Sets the common name for the star.
   *
   * @param proper the common name for the star
   */
  public void setProper(String proper) {
    this.proper = proper;
  }

  /**
   * Returns the star's right ascension for epoch and equinox 2000.0.
   *
   * @return ra
   */
  public double getRa() {
    return ra;
  }

  /**
   * Sets the star's right ascension, for epoch and equinox 2000.0.
   *
   * @param ra the star's right ascension, for epoch and equinox 2000.0.
   */
  public void setRa(double ra) {
    this.ra = ra;
  }

  /**
   * Returns the star's declination, for epoch and equinox 2000.0.
   *
   * @return dec
   */
  public double getDec() {
    return dec;
  }

  /**
   * Sets the star's declination, for epoch and equinox 2000.0.
   *
   * @param dec the star's declination, for epoch and equinox 2000.0.
   */
  public void setDec(double dec) {
    this.dec = dec;
  }

  /**
   * Returns the star's distance in parsecs
   */
  public double getDist() {
    return dist;
  }

  /**
   * Sets the star's distance in parsecs
   */
  public void setDist(double dist) {
    this.dist = dist;
  }

  /**
   * Returns the star's proper motion in right ascension
   */
  public double getPmra() {
    return pmra;
  }

  /**
   * Sets he star's proper motion in right ascension.
   */
  public void setPmra(double pmra) {
    this.pmra = pmra;
  }

  /**
   * Returns the star's proper motion in declination.
   */
  public double getPmdec() {
    return pmdec;
  }

  /**
   * Sets the star's proper motion in declination.
   */
  public void setPmdec(double pmdec) {
    this.pmdec = pmdec;
  }

  /**
   * Returns the star's radial velocity in km/sec, where known.
   */
  public Double getRv() {
    return rv;
  }

  /**
   * Sets the star's radial velocity in km/sec, where known.
   */
  public void setRv(Double rv) {
    this.rv = rv;
  }

  /**
   * Returns the star's apparent visual magnitude.
   */
  public double getMag() {
    return mag;
  }

  /**
   * Sets the star's apparent visual magnitude.
   */
  public void setMag(double mag) {
    this.mag = mag;
  }

  /**
   * Returns the star's absolute visual magnitude (its apparent magnitude from a distance of 10
   * parsecs).
   */
  public double getAbsmag() {
    return absmag;
  }

  /**
   * Sets the star's absolute visual magnitude (its apparent magnitude from a distance of 10
   * parsecs).
   */
  public void setAbsmag(double absmag) {
    this.absmag = absmag;
  }

  /**
   * Returns the star's spectral type, if known.
   */
  public String getSpect() {
    return spect;
  }

  /**
   * Sets the star's spectral type, if known.
   */
  public void setSpect(String spect) {
    this.spect = spect;
  }

  /**
   * Returns the star's color index (blue magnitude - visual magnitude), where known.
   */
  public Double getCi() {
    return ci;
  }

  /**
   * Sets the star's color index (blue magnitude - visual magnitude), where known.
   */
  public void setCi(Double ci) {
    this.ci = ci;
  }

  /**
   * Returns the Cartesian coordinates of the star, in a system based on the equatorial coordinates
   * as seen from Earth. +X is in the direction of the vernal equinox (at epoch 2000)
   */
  public double getX() {
    return x;
  }

  /**
   * Sets the Cartesian coordinates of the star, in a system based on the equatorial coordinates as
   * seen from Earth. +X is in the direction of the vernal equinox (at epoch 2000)
   */
  public void setX(double x) {
    this.x = x;
  }

  /**
   * Returns the Cartesian coordinates of the star, in a system based on the equatorial coordinates
   * as seen from Earth. +Y in the direction of R.A. 6 hours, declination 0 degrees.
   */
  public double getY() {
    return y;
  }

  /**
   * Sets the Cartesian coordinates of the star, in a system based on the equatorial coordinates as
   * seen from Earth. +Y in the direction of R.A. 6 hours, declination 0 degrees.
   */
  public void setY(double y) {
    this.y = y;
  }

  /**
   * Returns the Cartesian coordinates of the star, in a system based on the equatorial coordinates
   * as seen from Earth. +Z towards the north celestial pole.
   */
  public double getZ() {
    return z;
  }

  /**
   * Sets the Cartesian coordinates of the star, in a system based on the equatorial coordinates as
   * seen from Earth. +Z towards the north celestial pole.
   */
  public void setZ(double z) {
    this.z = z;
  }

  /**
   * Returns the Cartesian velocity components of the star, in the same coordinate system described
   * immediately above.
   */
  public Double getVx() {
    return vx;
  }

  /**
   * Sets the Cartesian velocity components of the star, in the same coordinate system described
   * immediately above.
   */
  public void setVx(Double vx) {
    this.vx = vx;
  }

  /**
   * Returns the Cartesian velocity components of the star, in the same coordinate system described
   * immediately above.
   */
  public Double getVy() {
    return vy;
  }

  /**
   * Sets the Cartesian velocity components of the star, in the same coordinate system described
   * immediately above.
   */
  public void setVy(Double vy) {
    this.vy = vy;
  }

  /**
   * Returns the Cartesian velocity components of the star, in the same coordinate system described
   * immediately above.
   */
  public Double getVz() {
    return vz;
  }

  /**
   * Sets the Cartesian velocity components of the star, in the same coordinate system described
   * immediately above.
   */
  public void setVz(Double vz) {
    this.vz = vz;
  }

  /**
   * Returns the position in radians
   */
  public double getRarad() {
    return rarad;
  }

  /**
   * Sets the position in radians
   */
  public void setRarad(double rarad) {
    this.rarad = rarad;
  }

  /**
   * Returns the position in radians.
   */
  public double getDecrad() {
    return decrad;
  }

  /**
   * Sets the position in radians.
   */
  public void setDecrad(double decrad) {
    this.decrad = decrad;
  }

  /**
   * Returns the position in proper radians.
   */
  public double getPmrarad() {
    return pmrarad;
  }

  /**
   * Sets the position in proper radians.
   */
  public void setPmrarad(double pmrarad) {
    this.pmrarad = pmrarad;
  }

  /**
   * Returns the position in proper radians.
   */
  public double getPmdecrad() {
    return pmdecrad;
  }

  /**
   * Sets the position in proper radians.
   */
  public void setPmdecrad(double pmdecrad) {
    this.pmdecrad = pmdecrad;
  }

  /**
   * Returns the Bayer designation as a distinct value.
   */
  public String getBayer() {
    return bayer;
  }

  /**
   * Sets the Bayer designation as a distinct value
   */
  public void setBayer(String bayer) {
    this.bayer = bayer;
  }

  /**
   * Returns the Flamsteed number as a distinct value.
   */
  public String getFlam() {
    return flam;
  }

  /**
   * Sets the Flamsteed number as a distinct value.
   */
  public void setFlam(String flam) {
    this.flam = flam;
  }

  /**
   * Returns the standard constellation abbreviation
   */
  public String getCon() {
    return con;
  }

  /**
   * Sets the standard constellation abbreviation.
   */
  public void setCon(String con) {
    this.con = con;
  }

  /**
   * Returns a star in a multiple star system. comp = ID of companion star.
   */
  public double getComp() {
    return comp;
  }

  /**
   * Sets a star in a multiple star system, comp = ID of companion star.
   */
  public void setComp(double comp) {
    this.comp = comp;
  }

  /**
   * Returns a star in a multiple star system. comp_primary = ID of primary star for this
   * component.
   */
  public double getComp_primary() {
    return comp_primary;
  }

  /**
   * Sets a star in a multiple star system. comp_primary = ID of primary star for this component.
   */
  public void setComp_primary(double comp_primary) {
    this.comp_primary = comp_primary;
  }

  /**
   * Returns a star in a multiple star system. Base = catalog ID or name for this multi-star
   * system.
   */
  public String getBase() {
    return base;
  }

  /**
   * Sets a star in a multiple star system. Base = catalog ID or name for this multi-star
   * system.
   * @param base
   */
  public void setBase(String base) {
    this.base = base;
  }

  /**
   * Returns a star's luminosity as a multiple of Solar luminosity.
   * @return
   */
  public double getLum() {
    return lum;
  }

  /**
   * Sets a star's luminosity as a multiple of Solar luminosity.
   * @param lum
   */
  public void setLum(double lum) {
    this.lum = lum;
  }

  /**
   * Returns a star's standard variable star designation, when known.
   * @return
   */
  public String getVar() {
    return var;
  }

  /**
   * Sets a star's standard variable star designation, when known.
   * @param var
   */
  public void setVar(String var) {
    this.var = var;
  }

  /**
   * Returns a star's approximate minimum magnitude.
   * @return
   */
  public Double getVar_min() {
    return var_min;
  }

  /**
   * Sets a star's approximate maximum magnitude.
   * @param var_min
   */
  public void setVar_min(Double var_min) {
    this.var_min = var_min;
  }

  /**
   * Returns a star's approximate maximum magnitude.
   * @return
   */
  public Double getVar_max() {
    return var_max;
  }

  /**
   * Sets a star's approximate maximum magnitude.
   * @param var_max
   */
  public void setVar_max(Double var_max) {
    this.var_max = var_max;
  }
}
