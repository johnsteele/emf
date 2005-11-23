/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * ModelImporterPage.java,v 1.9 2005/11/11 16:57:18 marcelop Exp
 */
package org.eclipse.emf.importer.ui.contribution.base;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.importer.ImporterPlugin;
import org.eclipse.emf.importer.ModelImporter;
import org.eclipse.emf.importer.util.ImporterUtil;


/**
 * @since 2.1.0
 */
public abstract class ModelImporterPage extends WizardPage implements Listener
{
  public static final int CAUSE_UNKNOWN = 0;
  public static final int CAUSE_BACK = 1;
  public static final int CAUSE_NEXT = 2;
  public static final int CAUSE_FINISH = 3;
  public static final int CAUSE_CANCEL = 4;
    
  protected ModelImporter modelImporter;
  protected boolean neverVisible = true;
  protected boolean forwardDirection = true;
  protected boolean handlingEvent = true;

  public ModelImporterPage(ModelImporter modelImporter, String pageName)
  {
    super(pageName);
    this.modelImporter = modelImporter;
    setPageComplete(false);
  }

  public void dispose()
  {
    modelImporter = null;
    super.dispose();
  }

  public ModelImporter getModelImporter()
  {
    return modelImporter;
  }

  protected void pageActivated(boolean firstTime, int cause)
  {
  }

  protected void pageDeactivated(int cause)
  {
  }
  
  public IWizardPage getNextPage()
  {
    forwardDirection = true;
    return super.getNextPage();
  }
  
  public IWizardPage getPreviousPage()
  {
    forwardDirection = false;
    return super.getPreviousPage();
  }

  public boolean isPageComplete()
  {
    return getErrorMessage() == null;
  }
  
  public boolean isHandlingEvent()
  {
    return handlingEvent;
  }
  
  public void setHandlingEvent(boolean handlingEvent)
  {
    this.handlingEvent = handlingEvent;
  }

  public void handleEvent(Event event)
  {
    if (isHandlingEvent())
    {
      doHandleEvent(event);
    }
  }
  
  protected void doHandleEvent(Event event)
  {
    
  }

  protected void handleDiagnostic(Diagnostic diagnostic)
  {
    handleDiagnostic(diagnostic, null, null, null);
  }
  
  protected void handleDiagnostic(Diagnostic diagnostic, String message, String dialogTitle, String dialogMessage)
  {
    if (diagnostic.getSeverity() == Diagnostic.OK)
    {
      handleOKDiagnostic(diagnostic, message, dialogTitle, dialogMessage);
    }
    else
    {
      handleNotOKDiagnostic(diagnostic, decodeAction(diagnostic), message, dialogTitle, dialogMessage);
    }
  }
  
  protected ImporterUtil.DecodedAction decodeAction(Diagnostic diagnostic)
  {
    int actionCode = ImporterUtil.computeActionCode(diagnostic);
    return ImporterUtil.decodeAction(actionCode);
  }
  
  protected void handleOKDiagnostic(Diagnostic diagnostic, String message, String dialogTitle, String dialogMessage)
  {
    setMessage(null);
    setErrorMessage(null);    
  }
  
  protected void handleNotOKDiagnostic(Diagnostic diagnostic, ImporterUtil.DecodedAction decodedAction, String message, String dialogTitle, String dialogMessage)
  {
    int messageType = 0;
    switch(diagnostic.getSeverity())
    {
      case Diagnostic.INFO:
      {
        messageType = IMessageProvider.INFORMATION;
        if (dialogTitle == null) dialogTitle = ImporterPlugin.INSTANCE.getString("_UI_DialogInformation_title");
        break;
      }
      case Diagnostic.WARNING:
        messageType = IMessageProvider.WARNING;
        if (dialogTitle == null) dialogTitle = ImporterPlugin.INSTANCE.getString("_UI_DialogWarning_title");
        break;
      case Diagnostic.ERROR:
        messageType = IMessageProvider.ERROR;
        if (dialogTitle == null) dialogTitle = ImporterPlugin.INSTANCE.getString("_UI_DialogError_title");
        break;
    }

    if (message == null) message = diagnostic.getMessage();
    setErrorMessage(null);
    setMessage(null);
    switch(decodedAction.message)
    {
      case ImporterUtil.ACTION_MESSAGE_SET:
      {
        setMessage(message);
        break;
      }
      case ImporterUtil.ACTION_DEFAULT:
      case ImporterUtil.ACTION_MESSAGE_SET_TYPED:
      {
        if (messageType == IMessageProvider.ERROR)
        {
          setErrorMessage(message);
        }
        else
        {
          setMessage(message, messageType);
        }
        break;
      }
      case ImporterUtil.ACTION_MESSAGE_SET_ERROR:
      {
        setErrorMessage(message);
        break;
      }
    }

    switch(decodedAction.dialog)
    {
      case ImporterUtil.ACTION_DEFAULT:
      case ImporterUtil.ACTION_DIALOG_SHOW_IF_HAS_CHILD:
      {
        if (!diagnostic.getChildren().isEmpty())
        {
          ErrorDialog.openError(getShell(), dialogTitle, dialogMessage, BasicDiagnostic.toIStatus(diagnostic));
        }
        break;
      }
      case ImporterUtil.ACTION_DIALOG_SHOW:
      {
        ErrorDialog.openError(getShell(), dialogTitle, dialogMessage, BasicDiagnostic.toIStatus(diagnostic));
        break;
      }
      case ImporterUtil.ACTION_DIALOG_SHOW_ERROR:
      {
        new ErrorDialog(getShell(),
          dialogTitle,
          dialogMessage,
          BasicDiagnostic.toIStatus(diagnostic), IStatus.INFO | IStatus.WARNING | IStatus.ERROR)
          {
            protected Image getImage()
            {
              return  getErrorImage();
            }
          }.open();
        break;
      }
    }
  }
}