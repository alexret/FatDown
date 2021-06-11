package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Ejercicio;
import com.fatdown.spring.entidades.Rutina;
import com.fatdown.spring.entidades.Usuario;
import com.fatdown.spring.repositorios.RutinaRepositorio;
import com.fatdown.spring.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RutinaServicioImp implements RutinaServicio {

    @Autowired
    RutinaRepositorio rutinaRepositorio;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EjercicioServicio ejercicioServicio;

    @Override
    public Rutina addRutina(String nombre,  HttpSession session) throws Exception {
        Rutina rutina = new Rutina();
        Optional<Usuario> usuario = usuarioRepository.findById((Long) session.getAttribute("idUsuario"));
        Set<Ejercicio> lEjercicio = (Set<Ejercicio>) session.getAttribute("tuRutina");
        Set<Ejercicio> ejercicioAux = new HashSet<Ejercicio>();


        rutina.setNombreRutina(nombre);
        rutina.setUsuario(usuario.get());

        for (Ejercicio e : lEjercicio) {
            Optional<Ejercicio> ejercicio = ejercicioServicio.buscarPorId(e.getIdEjercicio());
//            rutina.setEjercicio(lEjercicio.get(i));
            if(ejercicio.isPresent())
                ejercicioAux.add(ejercicio.get());
            else
                throw new Exception("Ha ocurrido un error");
        }
        rutina.setEjercicio(ejercicioAux);
        session.setAttribute("tuRutina", new HashSet<Ejercicio>());
        return rutinaRepositorio.save(rutina);
    }

    @Override
    public void deleteRutina(Rutina rutina) {

        rutinaRepositorio.delete(rutina);
    }

    @Override
    public List<Rutina> getRutinas(Usuario usuario) {

        return rutinaRepositorio.findByUsuario(usuario);
    }
}
