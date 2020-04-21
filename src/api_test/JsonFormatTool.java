package api_test;
/**
 * �����ṩ��ʽ��JSON�ַ����ķ�����
 * ����ķ���formatJson��JSON�ַ�����ʽ��������鿴JSON���ݡ�
 * <p>���磺
 * </p><p>JSON�ַ�����["yht","xzj","zwy"]
 * </p><p>��ʽ��Ϊ��
 * </p><p>[
 * </p><p>     "yht",
 * </p><p>     "xzj",
 * </p><p>     "zwy"
 * </p><p>]
 * 
 * </p><p>ʹ���㷨���£�
 * </p><p>�������ַ�����׷���ַ��ı���
 * </p><p>1����ȡ��ǰ�ַ���
 * </p><p>2�������ǰ�ַ���ǰ�����š�ǰ�����������´���
 * </p><p>��1�����ǰ�滹���ַ��������ַ�Ϊ����������ӡ�����к������ַ��ַ�����
 * </p><p>��2����ӡ����ǰ�ַ���
 * </p><p>��3��ǰ�����š�ǰ�����ţ��ĺ�����뻻�С���ӡ�����С�
 * </p><p>��4��ÿ����һ��ǰ�����š�ǰ�����ţ�������������һ�Ρ���ӡ������������
 * </p><p>��5��������һ��ѭ����
 * </p><p>3�������ǰ�ַ��Ǻ����š������������´���
 * </p><p>��1�������š������ţ���ǰ����뻻�С���ӡ�����С�
 * </p><p>��2��ÿ����һ�κ����š������ţ�������������һ�Ρ���ӡ��������
 * </p><p>��3����ӡ����ǰ�ַ���
 * </p><p>��4�������ǰ�ַ����滹���ַ��������ַ���Ϊ����������ӡ�����С�
 * </p><p>��5��������һ��ѭ����
 * </p><p>4�������ǰ�ַ��Ƕ��š����ź��滻�У������������ı�����������
 * </p><p>5����ӡ����ǰ�ַ���
 * 
 */
public class JsonFormatTool
{
    /**
     * ��λ�����ַ�����
     */
    private static String SPACE = "   ";

    /**
     * ���ظ�ʽ��JSON�ַ�����
     * 
     * @param json δ��ʽ����JSON�ַ�����
     * @return ��ʽ����JSON�ַ�����
     */
    public static String formatJson(String json)
    {
        StringBuffer result = new StringBuffer();

        int length = json.length();
        int number = 0;
        char key = 0;
        //���������ַ�����
        for (int i = 0; i < length; i++)
        {
            //1����ȡ��ǰ�ַ���
            key = json.charAt(i);

            //2�������ǰ�ַ���ǰ�����š�ǰ�����������´���
            if((key == '[') || (key == '{') )
            {
                //��1�����ǰ�滹���ַ��������ַ�Ϊ����������ӡ�����к������ַ��ַ�����
                if((i - 1 > 0) && (json.charAt(i - 1) == ':'))
                {
                    result.append('\n');
                    result.append(indent(number));
                }

                //��2����ӡ����ǰ�ַ���
                result.append(key);

                //��3��ǰ�����š�ǰ�����ţ��ĺ�����뻻�С���ӡ�����С�
                result.append('\n');

                //��4��ÿ����һ��ǰ�����š�ǰ�����ţ�������������һ�Ρ���ӡ������������
                number++;
                result.append(indent(number));

                //��5��������һ��ѭ����
                continue;
            }

            //3�������ǰ�ַ��Ǻ����š������������´���
            if((key == ']') || (key == '}') )
            {
                //��1�������š������ţ���ǰ����뻻�С���ӡ�����С�
                result.append('\n');

                //��2��ÿ����һ�κ����š������ţ�������������һ�Ρ���ӡ��������
                number--;
                result.append(indent(number));

                //��3����ӡ����ǰ�ַ���
                result.append(key);

                //��4�������ǰ�ַ����滹���ַ��������ַ���Ϊ����������ӡ�����С�
                if(((i + 1) < length) && (json.charAt(i + 1) != ','))
                {
                    result.append('\n');
                }

                //��5��������һ��ѭ����
                continue;
            }

            //4�������ǰ�ַ��Ƕ��š����ź��滻�У������������ı�����������
            if((key == ','))
            {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }

            //5����ӡ����ǰ�ַ���
            result.append(key);
        }

        return result.toString();
    }

    /**
     * ����ָ�������������ַ�����ÿһ�����������ո񣬼�SPACE��
     * 
     * @param number ����������
     * @return ָ�������������ַ�����
     */
    private static String indent(int number)
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0; i < number; i++)
        {
            result.append(SPACE);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        JsonFormatTool json = new JsonFormatTool();
        String str = "{'age':23,'aihao':['pashan','movies'],'name':{'firstName':'zhang','lastName':'san','aihao':['pashan','movies','name':{'firstName':'zhang','lastName':'san','aihao':['pashan','movies']}]}}";
        String result = json.formatJson(str);

        System.out.println(result);

    }
}