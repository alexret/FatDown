package com.fatdown.spring.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.entidades.Video;

@Entity
@Table(name = "USUARIO")
/* POJO */
public class Usuario implements Serializable {

	private static final long serialVersionUID = -8548755844378572455L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private Long idUsuario;

	// Datos personales

//	@Column(name = "USERNAME")
//	private String username;

	@Column(name = "NOMBRE_USUARIO")
	private String nombreUsuario;

	@Column(name = "APELLIDOS_USUARIO")
	private String apellidosUsuario;

	@Column(name = "PASSWORD_USUARIO")
	private String passwordUsuario;

	@Column(name = "EMAIL_USUARIO")
	private String emailUsuario;

	@Column(name = "FECHANAC_USUARIO")
	private String fechanacUsuario;

	// Datos de pago

	@Column(name = "NUMTARJETA_USUARIO")
	private String numtarjetaUsuario;

	@Column(name = "TITULAR_USUARIO")
	private String titularUsuario;

	@Column(name = "CODSEG_USUARIO")
	private String codsegUsuario;

	@Column(name = "DIRECFACT_USUARIO")
	private String direcfactUsuario;

	// Relación ManyToMany Rol

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "USUARIO_ROL", joinColumns = @JoinColumn(name = "ID_USUARIO"), inverseJoinColumns = @JoinColumn(name = "ID_ROL"))
	private Set<Rol> roles = new HashSet<>();

	// Relación OneToMany Rutina - propietaria

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Rutina> rutinas = new HashSet<>();

	// Relación OneToMany Video - propietaria

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Video> videos = new HashSet<>();

	// Constructores

	public Usuario() {

	}

	public Usuario(Long idUsuario, String nombreUsuario, String apellidosUsuario, String passwordUsuario,
			String emailUsuario, String fechanacUsuario, String numtarjetaUsuario, String titularUsuario,
			String codsegUsuario, String direcfactUsuario, Set<Rol> roles) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.passwordUsuario = passwordUsuario;
		this.emailUsuario = emailUsuario;
		this.fechanacUsuario = fechanacUsuario;
		this.numtarjetaUsuario = numtarjetaUsuario;
		this.titularUsuario = titularUsuario;
		this.codsegUsuario = codsegUsuario;
		this.direcfactUsuario = direcfactUsuario;
		this.roles = roles;
	}

	public Usuario(String nombreUsuario, String apellidosUsuario, String passwordUsuario, String emailUsuario,
			String fechanacUsuario, String numtarjetaUsuario, String titularUsuario, String codsegUsuario,
			String direcfactUsuario, Set<Rol> roles) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.passwordUsuario = passwordUsuario;
		this.emailUsuario = emailUsuario;
		this.fechanacUsuario = fechanacUsuario;
		this.numtarjetaUsuario = numtarjetaUsuario;
		this.titularUsuario = titularUsuario;
		this.codsegUsuario = codsegUsuario;
		this.direcfactUsuario = direcfactUsuario;
		this.roles = roles;
	}

// Constructores con username
//	public Usuario(Long idUsuario, String username, String nombreUsuario, String apellidosUsuario,
//			String passwordUsuario, String emailUsuario, String fechanacUsuario, String numtarjetaUsuario,
//			String titularUsuario, String codsegUsuario, String direcfactUsuario, Set<Rol> roles) {
//		super();
//		this.idUsuario = idUsuario;
//		this.username = username;
//		this.nombreUsuario = nombreUsuario;
//		this.apellidosUsuario = apellidosUsuario;
//		this.passwordUsuario = passwordUsuario;
//		this.emailUsuario = emailUsuario;
//		this.fechanacUsuario = fechanacUsuario;
//		this.numtarjetaUsuario = numtarjetaUsuario;
//		this.titularUsuario = titularUsuario;
//		this.codsegUsuario = codsegUsuario;
//		this.direcfactUsuario = direcfactUsuario;
//		this.roles = roles;
//	}
//	
//	public Usuario(String username, String nombreUsuario, String apellidosUsuario, String passwordUsuario,
//			String emailUsuario, String fechanacUsuario, String numtarjetaUsuario, String titularUsuario,
//			String codsegUsuario, String direcfactUsuario, Set<Rol> roles) {
//		super();
//		this.username = username;
//		this.nombreUsuario = nombreUsuario;
//		this.apellidosUsuario = apellidosUsuario;
//		this.passwordUsuario = passwordUsuario;
//		this.emailUsuario = emailUsuario;
//		this.fechanacUsuario = fechanacUsuario;
//		this.numtarjetaUsuario = numtarjetaUsuario;
//		this.titularUsuario = titularUsuario;
//		this.codsegUsuario = codsegUsuario;
//		this.direcfactUsuario = direcfactUsuario;
//		this.roles = roles;
//	}

	// Getters y setters

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

// Get y set de username
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getFechanacUsuario() {
		return fechanacUsuario;
	}

	public void setFechanacUsuario(String fechanacUsuario) {
		this.fechanacUsuario = fechanacUsuario;
	}

	public String getNumtarjetaUsuario() {
		return numtarjetaUsuario;
	}

	public void setNumtarjetaUsuario(String numtarjetaUsuario) {
		this.numtarjetaUsuario = numtarjetaUsuario;
	}

	public String getTitularUsuario() {
		return titularUsuario;
	}

	public void setTitularUsuario(String titularUsuario) {
		this.titularUsuario = titularUsuario;
	}

	public String getCodsegUsuario() {
		return codsegUsuario;
	}

	public void setCodsegUsuario(String codsegUsuario) {
		this.codsegUsuario = codsegUsuario;
	}

	public String getDirecfactUsuario() {
		return direcfactUsuario;
	}

	public void setDirecfactUsuario(String direcfactUsuario) {
		this.direcfactUsuario = direcfactUsuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Métodos Rol

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public boolean anadirRol(Rol rol) {
		rol.anadirUsuario(this);
		return getRoles().add(rol);
	}

	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);
		rol.getUsuarios().remove(this);
	}

	// Métodos Rutina

	public Set<Rutina> getRutinas() {
		return rutinas;
	}

	public void setRutinas(Set<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public boolean anadirRutinas(Rutina rutina) {
		rutina.setUsuario(this);
		return getRutinas().add(rutina);
	}

	public void eliminarRutina(Rutina rutina) {
		getRutinas().remove(rutina);
	}

	// Métodos Video

	public Set<Video> getVideos() {
		return videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}

	public boolean anadirVideos(Video video) {
		video.setUsuario(this);
		return getVideos().add(video);
	}

	public void eliminarVideo(Video video) {
		getVideos().remove(video);
	}

}