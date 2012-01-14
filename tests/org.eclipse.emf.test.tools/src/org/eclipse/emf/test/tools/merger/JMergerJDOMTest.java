/**
 * Copyright (c) 2004-2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 */
package org.eclipse.emf.test.tools.merger;

import java.io.File;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.codegen.merge.java.facade.FacadeHelper;
import org.eclipse.emf.codegen.merge.java.facade.jdom.JDOMFacadeHelper;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.jdt.core.JavaCore;


/**
 * Each test method in this class works with same directory as {@link JMergerTest}.
 * <p>
 * This test should contain special test cases that require special code executed for them.
 * Special cases will use directory returned by {@link #getDefaultDataDirectory()}.
 * <p>
 * In addition, this test is ran automatically by {@link JMergerTestSuite} for all input directories.
 *  
 * @see #JMergerJDOMTest(TestSuite, File)
 */
public class JMergerJDOMTest extends JMergerTest
{
  /**
   * @param name
   */
  public JMergerJDOMTest(String name)
  {
    super(name);
  }

  /**
   * Adds itself to test suite if possible by {@link #addItself(TestSuite)}.
   * <p>
   * Sets test name to be <code>mergeJDOM</code>.
   * 
   * @param ts
   * @param dataDirectory
   * @see #mergeJDOM()
   */
  public JMergerJDOMTest(TestSuite ts, File dataDirectory)
  {
    super(ts, dataDirectory);
    setName("mergeJDOM");
  }

  /**
   * Name of the expected output file when JDOM facade implementation is used.
   * @see #getTestSpecificExpectedOutput() 
   */
  public static final String JDOM_EXPECTED_OUTPUT_FILENAME = "JDOMMergerExpected.java";

  /**
   * Special test cases that are not in {@link JMergerTestSuite}
   */
  public static Test suite()
  {
    TestSuite ts = new TestSuite("JMerger JDOM Test");
    ts.addTest(new JMergerJDOMTest("merge4"));
    return ts;
  }

  /*
   * Bugzilla 163856
   */
  public void merge4() throws Exception
  {
    adjustSourceCompatibility(JavaCore.VERSION_1_5);
    applyGenModelEditorFormatting = true;
    verifyMerge(expectedOutput, mergeFiles());
  }

  /**
   * Method to be used in tests created based on data directories.
   * @throws Exception
   * @see #addItself(TestSuite)
   * @see JMergerTestSuite
   */
  public void mergeJDOM() throws Exception
  {
    merge();
  }

  @Override
  protected void instanceTest(FacadeHelper facadeHelper)
  {
    assertTrue(JDOMFacadeHelper.class.isInstance(facadeHelper));
  }

  @Override
  protected FacadeHelper instanciateFacadeHelper()
  {
    FacadeHelper facadeHelper = CodeGenUtil.instantiateFacadeHelper(JDOMFacadeHelper.class.getCanonicalName());
    return facadeHelper;
  }

  @Override
  protected File getTestSpecificExpectedOutput()
  {
    return new File(getDataDirectory(), JDOM_EXPECTED_OUTPUT_FILENAME);
  }

  /**
   * Adds itself only if java version is 1.4 based on directory ({@link #computeExpectedOutputFile()}
   * and if possible by {@link JMergerTest#addItself(TestSuite)}.
   * 
   * @see org.eclipse.emf.test.tools.merger.JMergerTest#addItself(junit.framework.TestSuite)
   */
  @Override
  public void addItself(TestSuite ts)
  {
    String javaVersion = computeJavaVersion();
    if (JavaCore.VERSION_1_4.equals(javaVersion))
    {
      super.addItself(ts);
    }
  }
}
