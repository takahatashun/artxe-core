package me.kazoku.artxe.database.general;

/**
 * The setting for connection
 */
public class Setting {
  private String host = "localhost";
  private String databaseName = "db";
  private int port = 3306;
  private String username = "";
  private String password = "";
  private boolean useSSL = false;
  private boolean certVerify = false;

  /**
   * Get the host
   *
   * @return the host
   */
  public String getHost() {
    return host;
  }

  /**
   * Set the host
   *
   * @param host the host
   */
  public Setting setHost(String host) {
    this.host = host;
    return this;
  }

  /**
   * Get the database name
   *
   * @return the database name
   */
  public String getDatabaseName() {
    return databaseName;
  }

  /**
   * Set the database name
   *
   * @param databaseName the database name
   */
  public Setting setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
    return this;
  }

  /**
   * Get the port
   *
   * @return the port
   */
  public int getPort() {
    return port;
  }

  /**
   * Set the port
   *
   * @param port the port
   */
  public Setting setPort(int port) {
    this.port = port;
    return this;
  }

  /**
   * Get the username
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Set the username
   *
   * @param username the username
   */
  public Setting setUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get the password
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the password
   *
   * @param password the password
   */
  public Setting setPassword(String password) {
    this.password = password;
    return this;
  }

  /**
   * Should it use SSL?
   *
   * @return the boolean
   */
  public boolean isUseSSL() {
    return useSSL;
  }

  /**
   * Should it use SSL?
   *
   * @param useSSL the boolean
   */
  public Setting setUseSSL(boolean useSSL) {
    this.useSSL = useSSL;
    return this;
  }

  /**
   * Should it verify the certificate ?
   *
   * @return the boolean
   */
  public boolean isCertVerify() {
    return certVerify;
  }

  /**
   * Should it verify the certificate ?
   *
   * @param certVerify the boolean
   */
  public Setting setCertVerify(boolean certVerify) {
    this.certVerify = certVerify;
    return this;
  }
}
