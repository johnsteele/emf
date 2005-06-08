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
 * $Id: NameMatchMappingCommand.java,v 1.1.2.1 2005/06/08 18:27:44 nickb Exp $
 */
package org.eclipse.emf.mapping.command;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.mapping.Mapping;
import org.eclipse.emf.mapping.domain.MappingDomain;


public class NameMatchMappingCommand extends MatchMappingCommand
{
  /**
   * This creates a command that creates a new child mappings for the given mapping 
   * by attempting to match by name input children with output children.
   */
  public static Command create(MappingDomain domain, Mapping mapping)
  {
    return domain.createCommand(NameMatchMappingCommand.class, new CommandParameter(mapping));
  }

  public NameMatchMappingCommand(MappingDomain domain, Mapping mapping)
  {
    super(domain, mapping);
  }

  protected boolean match(Object inputObject, Object outputObject, Collection mappedObjects)
  {
    String inputName = domain.getName(inputObject);
    String outputName = domain.getName(outputObject);

    if (inputName != null && outputName != null)
    {
      List parsedInputName = domain.parseInputName(inputName);
      List parsedOutputName = domain.parseOutputName(outputName);

      if (concatName(parsedInputName).equalsIgnoreCase(concatName(parsedOutputName)))
      {
        mappedObjects.add(inputObject);
      }
//    int parsedInputSize = parsedInputName.size();
//    if (parsedInputSize > 0 && parsedInputSize == parsedOutputName.size())
//    {
//      boolean match = true;
//      for (int i=0; i < parsedInputSize; i++)
//      {
//        String inputWord = (String)parsedInputName.get(i);
//        String outputWord = (String)parsedOutputName.get(i);
//        if (!inputWord.equalsIgnoreCase(outputWord))
//        { 
//          match = false;
//          break;
//        }
//      }
//      if (match)
//      {
//        mappedObjects.add(inputObject);
//      }
//    }
    }

    boolean multipleMatchesAllowed = (domain.getMappingEnablementFlags() & MappingDomain.ENABLE_MULTIPLE_INPUTS) != 0;
    return !multipleMatchesAllowed; // return false if iteration should continue.
  }

  protected String concatName(List parsedName)
  {
    String result = "";
    for (Iterator nameIter = parsedName.iterator(); nameIter.hasNext(); )
    {
      result += nameIter.next();
    }
    return result;
  }

  public void execute()
  {
    super.execute();

    // Now we'll do recursive MatchMapping.
    // (We need to iterate over a copy, since we modify the underlying list in the loop.)
    for (Iterator commands = new ArrayList(commandList).iterator(); commands.hasNext(); )
    {
      Command command = (Command)commands.next();
      appendAndExecute(NameMatchMappingCommand.create(domain, (Mapping)command.getResult().iterator().next()));
    }
  }

}
