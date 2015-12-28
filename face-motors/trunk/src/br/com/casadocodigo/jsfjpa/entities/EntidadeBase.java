package br.com.casadocodigo.jsfjpa.entities;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@SuppressWarnings("serial")
public abstract class EntidadeBase<T> implements Serializable {

	public abstract T getId();

	@Override
	public int hashCode() {
		return new HashCodeBuilder().appendSuper(super.hashCode())
				.append(getId()).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeBase<?> other = (EntidadeBase<?>) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(getId(), other.getId()).isEquals();
	}
}