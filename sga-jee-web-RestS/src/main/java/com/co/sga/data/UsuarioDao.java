package com.co.sga.data;

import java.util.List;

import com.co.sga.domain.Persona;
import com.co.sga.domain.Usuario;

public interface UsuarioDao {

	public List<Usuario> findUsuariosByIdPersona(Persona persona);
}
