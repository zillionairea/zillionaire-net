package net.zillions.mbg;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 
 */
public class CustomPlugin extends PluginAdapter {

	/**
	 * 
	 */
	private static final FullyQualifiedJavaType MODEL_INTERFACE = new FullyQualifiedJavaType("java.io.Serializable");

	/**
	 * @see org.mybatis.generator.api.PluginAdapter#initialized(org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public void initialized(IntrospectedTable introspectedTable) {

		// mapperClient
//		String myBatis3JavaMapperType = introspectedTable.getMyBatis3JavaMapperType();
//		introspectedTable.setMyBatis3JavaMapperType(myBatis3JavaMapperType.replace("Mapper", "MapperClient"));

		// model
//		String baseRecordType = introspectedTable.getBaseRecordType();
//		introspectedTable.setBaseRecordType(baseRecordType + "Model");

		// sqlId
		introspectedTable.setSelectByPrimaryKeyStatementId("findByPk");
		introspectedTable.setUpdateByPrimaryKeyStatementId("updateByPk");
		introspectedTable.setUpdateByPrimaryKeySelectiveStatementId("updateByPkSelective");
		introspectedTable.setUpdateByPrimaryKeyWithBLOBsStatementId("updateByPkWithBlob");
		introspectedTable.setDeleteByPrimaryKeyStatementId("deleteByPk");

		introspectedTable.setCountByExampleStatementId("countByEx");
		introspectedTable.setSelectByExampleStatementId("selectByEx");
		introspectedTable.setSelectByExampleWithBLOBsStatementId("selectByExWithBlob");
		introspectedTable.setUpdateByExampleStatementId("updateByEx");
		introspectedTable.setUpdateByExampleSelectiveStatementId("updateByExSelective");
		introspectedTable.setUpdateByExampleWithBLOBsStatementId("updateByExWithBlob");
		introspectedTable.setDeleteByExampleStatementId("deleteByEx");
	}

	/**
	 * @see org.mybatis.generator.api.Plugin#validate(java.util.List)
	 */
	public boolean validate(List<String> warnings) {
		return true;
	}

	/**
	 * @see org.mybatis.generator.api.PluginAdapter#modelBaseRecordClassGenerated(org.mybatis.generator.api.dom.java.TopLevelClass,
	 *      org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		setModelInterface(topLevelClass);
		return true;
	}

	/**
	 * @see org.mybatis.generator.api.PluginAdapter#modelPrimaryKeyClassGenerated(org.mybatis.generator.api.dom.java.TopLevelClass,
	 *      org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		setModelInterface(topLevelClass);
		return true;
	}

	/**
	 * @see org.mybatis.generator.api.PluginAdapter#modelRecordWithBLOBsClassGenerated(org.mybatis.generator.api.dom.java.TopLevelClass,
	 *      org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		setModelInterface(topLevelClass);
		return true;
	}

	/**
	 * 
	 * @param topLevelClass
	 */
	private void setModelInterface(TopLevelClass topLevelClass) {
		topLevelClass.addImportedType(MODEL_INTERFACE);
		topLevelClass.addSuperInterface(MODEL_INTERFACE);
	}

	/**
	 * @see org.mybatis.generator.api.PluginAdapter#clientGenerated(org.mybatis.generator.api.dom.java.Interface,
	 *      org.mybatis.generator.api.dom.java.TopLevelClass, org.mybatis.generator.api.IntrospectedTable)
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return true;
	}

}