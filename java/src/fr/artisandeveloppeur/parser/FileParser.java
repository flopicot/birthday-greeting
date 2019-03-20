package fr.artisandeveloppeur.parser;

import java.util.Collection;

public interface FileParser<T> {
	Collection<T> retrieveData() throws Exception;
}
