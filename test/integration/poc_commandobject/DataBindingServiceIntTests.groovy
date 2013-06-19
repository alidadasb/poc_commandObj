package poc_commandobject

import com.netjets.commandObjects.SampleCommand

import static org.junit.Assert.*
import org.junit.*

class DataBindingServiceIntTests extends GroovyTestCase{
    def binderService
    def cmd
    def messageDomain


    @Before
    void setUp() {
        cmd = new SampleCommand()
        //messageDomain = new Message()
    }

    @After
    void tearDown() {
        cmd.properties.each {println it }
        cmd.errors.allErrors.each {println it }
    }

    @Test
    void testBindingDomain() {
        //println new Date().format('yyyy-MM-dd HH:mm:ss.S')
        //def map = [name:"Ali",number:"123", departure: Date.parse("yyyy-MM-dd'T'HH:mm:ss'Z'", '2013-06-19T10:00:15Z')]//"Tue Jun 18 16:51:09 EDT 2013"
        def map = [name:"Ali",number:"123", departure:'2013-06-19 10:00:15.234']
        //binderService.bind(messageDomain,map)
        messageDomain = new Message(map).save(failOnError: true)
        //assert messageDomain.validate()
        //assert messageDomain.save()

        assertEquals "Ali",  messageDomain.name
        assertEquals 123   , messageDomain.number
        assertEquals "2013-06-19T10:00:15Z"   , messageDomain.departure.toString()
        assertFalse messageDomain.hasErrors()
    }

    @Test
    void testBinding() {
        def map = ['name':"Ali", 'number':"123", 'departure':"2013-06-19 10:00:15.234"]//"Tue Jun 18 16:51:09 EDT 2013"
        binderService.bind(cmd,map)

        assertEquals "Ali",  cmd.name
        assertEquals 123   , cmd.number
        assertEquals "2013-06-19T10:00:15Z"   , cmd.departure.toString()
        assertFalse cmd.hasErrors()
    }

    @Test
    void testBindingNotBlank() {
        def map = [number:"123", departure:"2013-06-19T10:00:15Z"]
        binderService.bind(cmd,map)

        assertTrue cmd.hasErrors()
    }

    @Test
    void testBindingDate() {
        def map = [name:"Ali",number:"123", departure:"2013-06-19T10:00:15Z"]
        binderService.bind(cmd,map)

        assertEquals "2013-06-19" , cmd.departure.toString()
    }

}
