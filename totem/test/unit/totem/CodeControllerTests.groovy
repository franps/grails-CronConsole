package totem



import org.junit.*
import grails.test.mixin.*

/**
 * CodeControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(CodeController)
@Mock(Code)
class CodeControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/code/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.codeInstanceList.size() == 0
        assert model.codeInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.codeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.codeInstance != null
        assert view == '/code/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/code/show/1'
        assert controller.flash.message != null
        assert Code.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/code/list'


        populateValidParams(params)
        def code = new Code(params)

        assert code.save() != null

        params.id = code.id

        def model = controller.show()

        assert model.codeInstance == code
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/code/list'


        populateValidParams(params)
        def code = new Code(params)

        assert code.save() != null

        params.id = code.id

        def model = controller.edit()

        assert model.codeInstance == code
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/code/list'

        response.reset()


        populateValidParams(params)
        def code = new Code(params)

        assert code.save() != null

        // test invalid parameters in update
        params.id = code.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/code/edit"
        assert model.codeInstance != null

        code.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/code/show/$code.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        code.clearErrors()

        populateValidParams(params)
        params.id = code.id
        params.version = -1
        controller.update()

        assert view == "/code/edit"
        assert model.codeInstance != null
        assert model.codeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/code/list'

        response.reset()

        populateValidParams(params)
        def code = new Code(params)

        assert code.save() != null
        assert Code.count() == 1

        params.id = code.id

        controller.delete()

        assert Code.count() == 0
        assert Code.get(code.id) == null
        assert response.redirectedUrl == '/code/list'
    }
}
