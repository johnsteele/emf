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
 * $Id: EList.java,v 1.1.2.1 2005/06/08 18:27:42 nickb Exp $
 */
package org.eclipse.emf.common.util;


import java.util.List;


/**
 * A list that supports move.
 */
public interface EList extends List
{
  /**
   * Moves the object to the new position, if is in the list.
   * @param newPosition the position of the object after the move.
   * @param object the object to move.
   */
  void move(int newPosition, Object object);

  /**
   * Moves the object from the old position to the new position.
   * @param newPosition the position of the object after the move.
   * @param oldPosition the position of the object before the move.
   * @return the moved object.
   */
  Object move(int newPosition, int oldPosition);
}
