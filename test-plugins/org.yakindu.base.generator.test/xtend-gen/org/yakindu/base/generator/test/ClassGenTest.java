package org.yakindu.base.generator.test;

import java.util.ArrayList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.generator.ParameterGen;
import org.yakindu.base.generator.Visibility;
import org.yakindu.base.generator.test.AbstractGeneratorTest;
import org.yakindu.base.generator.test.util.GeneratorInjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(GeneratorInjectorProvider.class)
@SuppressWarnings("all")
public class ClassGenTest extends AbstractGeneratorTest {
  @Test
  public void testSimpleClassLayout() {
    this.testClass.setClassName("testClass");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class testClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testClass);
  }
  
  @Test
  public void testVisibility() {
    this.testClass.setClassName("PrivateClass");
    this.testClass.setVisibility(Visibility.PRIVATE);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private class PrivateClass {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testClass);
  }
  
  @Test
  public void testConstructor() {
    this.testClass.setClassName("hasConstructor");
    ArrayList<ParameterGen> _newArrayList = CollectionLiterals.<ParameterGen>newArrayList();
    this.testClass.addConstructor(_newArrayList);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class hasConstructor {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public hasConstructor() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String exp = _builder.toString();
    this.generatesTo(exp, this.testClass);
  }
}
