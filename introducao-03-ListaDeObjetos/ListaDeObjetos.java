import java.util.*;
public class ListaDeObjetos<E>
{	
	private ArrayList<E> lista;
	private int corrente = -1;

	public ListaDeObjetos (int tam)
	{	lista = new ArrayList<E>(tam);
	}

	public void adicionar(E obj)
	{	lista.add(obj);
	}

	public int tamanho()
	{	return lista.size();
	}

	public boolean remover(int numero)
	{	
		int n = this.localizar(numero);
		if (n == -1)
		{	return false;
		}
		else
		{	lista.remove(n);
			return true;
		}
	}

	public boolean vazia()
	{	return lista.isEmpty();		
	}

	public E recuperar(int numero)
	{		
		int n = this.localizar(numero);
		if(n == -1)
		{	return null;
		}
		else
		{	return lista.get(n);
		}
	}

	private int localizar(int numero)
	{		
		Integer num = new Integer(numero);
		
		for(int i=0; i<lista.size(); i++)
		{	if(lista.get(i).equals(num))
			{	
				return i;
			}
		}
		return -1;
	}

	public E recuperarPrimeiro()
	{		
		if(lista.isEmpty())
		{	return null;
		}
		else
		{	corrente = 0;
			return lista.get(corrente);
		}
	}
						
	public E recuperarProximo()
	{	if(corrente == -1)
		{	throw new ArrayIndexOutOfBoundsException("Fora dos limites.");
		}
		else
		{	corrente++;
			if(corrente < lista.size())
			{	return lista.get(corrente);
			}
			else
			{	corrente = -1;
				return null;
			}
		}
	}
}







