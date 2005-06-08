/**
 * <copyright>
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TypeMatchMappingCommand.java,v 1.1.2.1 2005/06/08 18:27:44 nickb Exp $
 */
package org.eclipse.emf.mapping.command;


import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.mapping.Mapping;
import org.eclipse.emf.mapping.domain.MappingDomain;


public class TypeMatchMappingCommand extends MatchMappingCommand
{
  /**
   * This creates a command that creates a new child mappings for the given mapping 
   * by attempting to match by type input children with output children.
   */
  public static Command create(MappingDomain domain, Mapping mapping)
  {
    return domain.createCommand(TypeMatchMappingCommand.class, new CommandParameter(mapping));
  }

  public TypeMatchMappingCommand(MappingDomain domain, Mapping mapping)
  {
    super(domain, mapping);
  }

  protected boolean match(Object inputObject, Object outputObject, Collection mappedObjects)
  {
    if (mappedInputs.contains(inputObject) || !domain.getMappingRoot().getMappings(inputObject).isEmpty())
    {
      return false; // Type matching never matches inputs that are already mapped
    }

    Object inputType = domain.getTypeClassifier(inputObject);
    if (inputType != null)
    {
      Object outputType = domain.getTypeClassifier(outputObject);
      Object convertedInputType = domain.getOutputTypeClassifier(inputType);

      if (outputType != null && outputType == convertedInputType)
      {
        mappedObjects.add(inputObject);
        return true;
      }
    }

    return false;
  }

}
